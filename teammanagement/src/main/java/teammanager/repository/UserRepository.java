package teammanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teammanager.entity.Authority;
import teammanager.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByPhone(String phone);

    boolean existsByUsername(String username);

    boolean existsByEmailAndIdNot(String email, Long id);

    boolean existsByPhoneAndIdNot(String phone, Long id);

    List<User> findByActiveTrue();

    List<User> findByAuthorities_Role(Authority.Role role);

    long countByAuthorities_Role(Authority.Role role);

    List<User> findByAuthorities_RoleNot(Authority.Role role);
}