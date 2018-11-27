package firstyear.project.controllers;

import firstyear.project.models.SalesOverview;
import firstyear.project.services.SalesOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SalesOverviewController {

    @Autowired
    SalesOverviewService salesOverviewService;



    private final String INDEX = "index";

    @GetMapping("/")
    public String index(Model model){
       return INDEX;
    }
}
