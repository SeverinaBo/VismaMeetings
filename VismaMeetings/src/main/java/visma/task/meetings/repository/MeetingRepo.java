package visma.task.meetings.repository;

import visma.task.meetings.meetingModel.Meeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, Long> {

    @Query(value = "SELECT m FROM Meeting m")
    List<Meeting> getAllMeetings();

}
