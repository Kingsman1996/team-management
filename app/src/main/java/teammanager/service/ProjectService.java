package teammanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teammanager.dto.project.ProjectRequest;
import teammanager.entity.Project;
import teammanager.mapper.ProjectMapper;
import teammanager.repository.ProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public void create(ProjectRequest projectRequest) {
        projectRepository.save(projectMapper.toEntity(projectRequest));
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
