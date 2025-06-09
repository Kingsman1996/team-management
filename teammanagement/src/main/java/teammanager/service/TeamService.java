package teammanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teammanager.dto.team.CreateTeamRequest;
import teammanager.entity.Team;
import teammanager.entity.User;
import teammanager.exception.NotFoundException;
import teammanager.mapper.TeamMapper;
import teammanager.repository.TeamRepository;
import teammanager.repository.UserRepository;
import teammanager.util.MessageHelper;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private  final UserRepository userRepository;
    private final MessageHelper messageHelper;
    private final TeamMapper teamMapper;

    public void add(CreateTeamRequest createTeamRequest) {
        Team team = teamMapper.toEntity(createTeamRequest);
        User leader = userRepository.findById(createTeamRequest.getLeaderId())
                .orElseThrow(() -> new NotFoundException(messageHelper.get("user.notFound")));
        team.setLeader(leader);
        teamRepository.save(team);
    }
}
