package teammanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import teammanager.entity.Authority;
import teammanager.entity.User;
import teammanager.repository.AuthorityRepository;
import teammanager.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DatabaseStarter implements CommandLineRunner {
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        for (Authority.Role role : Authority.Role.values()) {
            if (!authorityRepository.existsByRole(role)) {
                Authority authority = new Authority();
                authority.setRole(role);
                authorityRepository.save(authority);
            }
        }
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("Admin@123");
            Set<Authority> authorities = new HashSet<>();
            authorities.add(authorityRepository.findByRole(Authority.Role.ADMIN));
            admin.setAuthorities(authorities);
            userRepository.save(admin);
        }
    }
}
