package visma.task.meetings.meetingModel;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;


@Builder
@Data
@Entity
@Table(name = "MEETINGS")
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEETINGID")
    private Long meetingId;

    @Column(name = "MEETINGNAME")
    private String meetingName;

    @Column(name = "RESPONSIBLEPERSON")
    private String responsiblePerson;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private String category;

    @Embedded
    private String type;

    @Column(name = "STARTDATE")
    private LocalDateTime startDate;

    @Column(name = "ENDDATE")
    private LocalDateTime endDate;
}
