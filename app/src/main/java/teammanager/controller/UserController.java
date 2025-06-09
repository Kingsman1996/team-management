package teammanager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import teammanager.dto.user.LoginRequest;
import teammanager.dto.user.RegisterRequest;
import teammanager.dto.user.UserRequest;
import teammanager.entity.Authority;
import teammanager.service.UserService;
import teammanager.util.BindingHandler;
import teammanager.util.MessageHelper;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final MessageHelper messageHelper;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(BindingHandler.getErrorMessages(bindingResult));
        }
        userService.register(registerRequest);
        return ResponseEntity.status(201).body(messageHelper.get("register.success"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping({"", "/{role}"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getUserList(@PathVariable(required = false) String role) {
        if (role == null || role.trim().isEmpty()) {
            return ResponseEntity.ok(userService.findAll());
        }
        return ResponseEntity.ok(userService.findByRole(Authority.Role.valueOf(role.toUpperCase())));
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        return ResponseEntity.ok(userService.getStats());
    }

    @PatchMapping
    public ResponseEntity<?> update(@Valid @RequestBody UserRequest userRequest,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(BindingHandler.getErrorMessages(bindingResult));
        }
        userService.update(userRequest);
        return ResponseEntity.ok(messageHelper.get("user.update.success"));
    }

    @PatchMapping("/{id}/authorities/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addAuthority(@PathVariable Long id, @RequestBody String role) {
        userService.addUserAuthority(id, role);
        return ResponseEntity.ok(messageHelper.get("authority.add.success"));
    }
}
