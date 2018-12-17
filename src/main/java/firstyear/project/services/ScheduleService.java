package firstyear.project.services;

import firstyear.project.controllers.salesOverviewController.SalesOverviewController;
import firstyear.project.models.Schedule;
import firstyear.project.repositories.scheduleRepo.ScheduleRepo;
import firstyear.project.repositories.scheduleRepo.ScheduleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.SheetCollate;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ScheduleService implements ScheduleRepo {

    @Autowired
    ScheduleRepoImpl scheduleRepo;

    private static final Logger LOGGER = Logger.getLogger(ScheduleService.class.getName());


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
        Schedule schedule = scheduleRepo.getSchedule(index);
        return schedule;
    }
    public Schedule getScheduleByDate(String date) {
        LOGGER.info("service getScheduleByDate was called with: " + date);
        Schedule schedule = scheduleRepo.getScheduleByDate(date);

        if (schedule.getScheduleId() == 0) {
            LOGGER.fine("Attempts to create a new schedule since none existed on " + date);
            schedule = scheduleRepo.createScheduleFromDate(date);
        } else {
            LOGGER.fine("the ID was " + schedule.getScheduleId() + " something probably went wrong.");
        }

        return schedule;
    }

    @Override
    public List<Schedule> getSchedules(LocalDate start, LocalDate end) {
        return scheduleRepo.getSchedules(start, end);
    }

    public LinkedList<Schedule> getLinkedListSchedules(LocalDate start, LocalDate end) {
        LinkedList<Schedule> linkedSchedules = new LinkedList<>();
        List<Schedule> schedules = scheduleRepo.getSchedules(start, end);
        for (Schedule s : schedules){
            linkedSchedules.add(s);
        }
        return linkedSchedules;
    }

    public List<Schedule> populateMonth(LocalDate start, LocalDate end){
        LOGGER.info("populate month was called with: " + start + " and " + end);
        // This method makes the empty schedule days that are in between the ones saved in the database.
        LinkedList<Schedule> existingSchedules = getLinkedListSchedules(start, end);
        List<Schedule> schedules = new ArrayList<>();
        YearMonth yearMonth = YearMonth.of(start.getYear(), start.getMonthValue());
        int lengthOfMonth = yearMonth.lengthOfMonth();

        for (int i = 1; i < lengthOfMonth + 1; i++ ) {
            if (existingSchedules.peekFirst() != null) {

                if (existingSchedules.peekFirst().getScheduleDate().getDayOfMonth() == i){
                    schedules.add(existingSchedules.removeFirst());
                } else {
                    Schedule schedule = new Schedule();
                    schedule.setScheduleDate(LocalDate.of(yearMonth.getYear(),yearMonth.getMonthValue(),i));
                    schedules.add(schedule);
                }
            } else {
                Schedule schedule = new Schedule();
                schedule.setScheduleDate(LocalDate.of(yearMonth.getYear(),yearMonth.getMonthValue(),i));
                schedules.add(schedule);
            }
        }
        return schedules;
    }

}
