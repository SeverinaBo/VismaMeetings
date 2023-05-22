package visma.task.meetings.service;

import visma.task.meetings.meetingModel.Meeting;
import visma.task.meetings.meetingModel.MeetingDto;
import visma.task.meetings.repository.MeetingRepo;
import visma.task.meetings.utils.CoreConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class MeetingServiceImpl implements MeetingService{

    private final MeetingRepo meetingRepo;

    @Override
    public List<MeetingDto> getAllMeetings() {
        return mapToDto(meetingRepo.getAllMeetings());
    }

    public Meeting save(Meeting meeting) {
        return meetingRepo.save(meeting);
    }

    public void saveAll(List<Meeting> meeting) {
        meetingRepo.saveAll(meeting);
    }

    @Override
    public String createMeeting(MeetingDto meetingDto){
        Meeting newMeeting = createNewMeeting(meetingDto);
        meetingRepo.save(newMeeting);
        return newMeeting.getMeetingId() != null ? "success" : "failed";
    }

    @Override
    public void deleteMeetingById(Long id){
        meetingRepo.deleteById(id);
    }



    private Meeting createNewMeeting(MeetingDto meetingDto) {
        return Meeting.builder()
                .meetingId(meetingDto.getMeetingId())
                .meetingName(meetingDto.getMeetingName())
                .responsiblePerson(meetingDto.getResponsiblePerson())
                .description(meetingDto.getDescription())
                .category(meetingDto.getCategory())
                .type(meetingDto.getType())
                .build();

    }

    private List<MeetingDto> mapToDto(Collection<Meeting> entities){
        return entities.stream()
                .map(o -> MeetingDto.builder()
                        .meetingName(o.getMeetingName())
                        .responsiblePerson(o.getResponsiblePerson())
                        .description(o.getDescription())
                        .category(o.getCategory())
                        .type(o.getType())
                        .startDate(buildDateTimeLabel(o.getStartDate()))
                        .endDate(buildDateTimeLabel(o.getEndDate()))
                        .build())
                .collect(Collectors.toList());

    }

    private String buildDateTimeLabel(LocalDateTime createDate) {
        LocalDateTime rawDate = Optional.ofNullable(createDate)
                .orElseGet(LocalDateTime::now);
        return rawDate.format(CoreConstants.DATE_TIME_FORMATTER);
    }

}
