package firstyear.project.controllers.scheduleController;

import firstyear.project.models.Schedule;
import firstyear.project.repositories.scheduleRepo.ScheduleRepo;
import firstyear.project.repositories.shiftRepo.ShiftRepo;
import firstyear.project.services.ScheduleService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    private static final Logger LOGGER = Logger.getLogger(ScheduleController.class.getName());


    private final String SCHEDULES = "schedule/schedules.html";

    @RequestMapping("/schedule")
    public String index (Model model) {
        LOGGER.info("schedule index was called");

        YearMonth yearMonth = YearMonth.now();

        int lengthOfMonth = yearMonth.lengthOfMonth();

        int monthValue = yearMonth.getMonthValue();
        int yearValue = yearMonth.getYear();


        LocalDate start = LocalDate.of(yearValue, monthValue,1);
        LocalDate end = LocalDate.of(yearValue, monthValue,lengthOfMonth);

        List<Schedule> schedules = scheduleService.populateMonth(start, end);

        model.addAttribute("schedules", schedules);




        return SCHEDULES;
    }
}
