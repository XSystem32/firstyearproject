package firstyear.project.repositories.scheduleRepo;

import firstyear.project.models.Schedule;
import firstyear.project.repositories.JdbcFix;

import java.time.LocalTime;
import java.util.List;

public class ScheduleRepoImpl extends JdbcFix implements ScheduleRepo {

    public boolean createSchedule(Schedule schedule) {
    }

    public boolean deleteSchedule(int index) {
    }

    public boolean updateSchedule(Schedule schedule) {
    }

    public Schedule getSchedule(int index) {
        return null;
    }

    public List<Schedule> getSchedules(LocalTime start, LocalTime end) {
        return null;
    }
}
