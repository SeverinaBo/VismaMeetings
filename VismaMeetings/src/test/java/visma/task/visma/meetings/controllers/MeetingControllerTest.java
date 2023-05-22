package visma.task.visma.meetings.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import visma.task.meetings.controllers.MeetingController;
import visma.task.meetings.meetingModel.MeetingDto;
import visma.task.meetings.service.MeetingService;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MeetingControllerTest {

    @Mock
    private MeetingService meetingService;

    @InjectMocks
    private MeetingController meetingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllMeetings() {

        MeetingDto meeting1 = new MeetingDto();
        MeetingDto meeting2 = new MeetingDto();
        List<MeetingDto> expectedMeetings = Arrays.asList(meeting1, meeting2);
        when(meetingService.getAllMeetings()).thenReturn(expectedMeetings);


        List<MeetingDto> actualMeetings = meetingController.getAllMeetings();


        assertEquals(expectedMeetings, actualMeetings);
    }
}

