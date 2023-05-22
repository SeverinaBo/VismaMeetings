package visma.task.meetings.controllers;

import visma.task.meetings.meetingModel.MeetingDto;
import visma.task.meetings.service.MeetingService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meeting")
@Api
public class MeetingController {

    private final MeetingService meetingService;


    @GetMapping("/allMeetings")
    public List<MeetingDto> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @PostMapping("/createMeeting")
    public String createMeeting(@RequestBody MeetingDto meetingDto){
        return meetingService.createMeeting(meetingDto);
    }

    @DeleteMapping("/{meetingId}")
    public void deleteByMeetingId(@PathVariable("meetingId") Long meetingId){
        meetingService.deleteMeetingById(meetingId);
    }
}
