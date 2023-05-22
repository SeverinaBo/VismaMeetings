package visma.task.meetings.meetingModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MeetingDto {

    private Long meetingId;

    private String meetingName;

    private String responsiblePerson;

    private String description;

    private String category;

    private String type;

    private String startDate;
    private String endDate;
}
