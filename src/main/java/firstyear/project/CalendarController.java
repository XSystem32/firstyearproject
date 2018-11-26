package firstyear.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class CalendarController {
    private final String INDEX = "index";

    @GetMapping("/")
    public String index(Model model){
        return INDEX;


    }

}
