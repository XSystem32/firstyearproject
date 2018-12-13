package firstyear.project.services;

import firstyear.project.models.Schedule;
import firstyear.project.repositories.scheduleRepo.ScheduleRepo;
import firstyear.project.repositories.scheduleRepo.ScheduleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduleService implements ScheduleRepo {

    @Autowired
    ScheduleRepoImpl scheduleRepo;

    @Override
    public boolean createSchedule(Schedule schedule) {
        scheduleRepo.createSchedule(schedule);
        return true;
    }

    @Override
    public boolean deleteSchedule(int index) {
        scheduleRepo.deleteSchedule(index);
        return true;
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        scheduleRepo.updateSchedule(schedule);
        return true;
    }

    @Override
    public Schedule getSchedule(int index) {
        return scheduleRepo.getSchedule(index);
    }

    @Override
    public List<Schedule> getSchedules(LocalDate start, LocalDate end) {
        return scheduleRepo.getSchedules(start, end);
    }
}
