package teammanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teammanager.dto.team.CreateTeamRequest;
import teammanager.service.TeamService;
import teammanager.util.MessageHelper;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private final MessageHelper messageHelper;

    @PostMapping
    public ResponseEntity<?> createTeam(@RequestBody CreateTeamRequest createTeamRequest) {
        teamService.add(createTeamRequest);
        return ResponseEntity.ok().body(messageHelper.get("create.team.success"));
    }
}
