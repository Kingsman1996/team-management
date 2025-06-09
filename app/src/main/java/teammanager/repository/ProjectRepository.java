package teammanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teammanager.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
