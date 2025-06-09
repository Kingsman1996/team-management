package teammanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teammanager.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
