package firstyear.project.controllers.scheduleController;

import firstyear.project.models.Schedule;
import firstyear.project.repositories.scheduleRepo.ScheduleRepo;
import firstyear.project.repositories.shiftRepo.ShiftRepo;
import firstyear.project.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;


public class ScheduleController {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ShiftRepo shiftRepo;

    @Autowired
    ScheduleService scheduleService;

    private static final Logger LOGGER = Logger.getLogger(ScheduleController.class.getName());


    private final String SCHEDULES = "schedule/schedules.html";

    @GetMapping("/test")
    public String index (Model model) {
        LOGGER.info("index was called");

        LocalDate nowMonth = LocalDate.now();
        int month = nowMonth.getMonthValue();


        LocalDate end = LocalDate.now();
        LocalDate start = end.plusWeeks(6);

        model.addAttribute("nowMonth",month);

        List<Schedule> schedules = scheduleService.getSchedules(LocalDate.from(end), LocalDate.now());

        return SCHEDULES;
    }
}
