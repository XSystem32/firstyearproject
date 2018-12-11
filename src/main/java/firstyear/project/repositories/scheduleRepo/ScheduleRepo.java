package firstyear.project.repositories.scheduleRepo;

import firstyear.project.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ScheduleRepo {

    boolean createSchedule (Schedule schedule);
    boolean deleteSchedule (int index);
    boolean updateSchedule (Schedule schedule);
    Schedule getSchedule (int index);
    List<Schedule> getSchedules (LocalTime start, LocalTime end);

}
