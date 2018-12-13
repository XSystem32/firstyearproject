package firstyear.project.services;

import firstyear.project.models.Schedule;
import firstyear.project.repositories.scheduleRepo.ScheduleRepo;
import firstyear.project.repositories.scheduleRepo.ScheduleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;
@Service
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

    public List<Schedule> populateMonth(LocalDate start, LocalDate end){
        // This method makes the empty schedule days that are in between the ones saved in the database.
        List<Schedule> schedules = getSchedules(start, end);
        YearMonth yearMonth = YearMonth.now();
        int lengthOfMonth = yearMonth.lengthOfMonth();

        for (int i = 1; i < lengthOfMonth; i++ ) {
            Schedule schedule = new Schedule();
            schedule.setScheduleDate(LocalDate.of(yearMonth.getYear(),yearMonth.getMonthValue(),i));
            schedules.add(schedule);
        }


        return schedules;
    }

}
