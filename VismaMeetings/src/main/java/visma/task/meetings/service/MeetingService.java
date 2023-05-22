package visma.task.meetings.service;

import visma.task.meetings.meetingModel.MeetingDto;

import java.util.List;
public interface MeetingService {

    List<MeetingDto> getAllMeetings();

    String createMeeting(MeetingDto meetingDto);

    void deleteMeetingById(Long id);

}
