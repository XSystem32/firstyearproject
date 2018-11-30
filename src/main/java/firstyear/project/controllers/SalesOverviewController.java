package firstyear.project.controllers;

import firstyear.project.models.SalesOverview;
import firstyear.project.services.SalesOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class SalesOverviewController {

    @Autowired
    SalesOverviewService salesOverviewService;

    private static final Logger LOGGER = Logger.getLogger(SalesOverviewController.class.getName());

    private String INDEX = "index.html";
    private String CREATEOVERVIEW = "createoverview.html";
    private String SALESOVERVIEW = "salesoverview.html";
    private String SALESOVERVIEWS = "salesoverviews.html";

    @GetMapping("/salesoverviews.html")
    public String overview (Model model) {
        LOGGER.info("index was called");
        return SALESOVERVIEWS;
    }

    @GetMapping("/index.html")
    public String index (Model model) {
        LOGGER.info("index was called");
        return INDEX;
    }
    @GetMapping("/test")
    public String test (Model model){
        LOGGER.info("test was called");
        return INDEX;
    }

    @GetMapping("/salesoverview.html")
    public String getSALESOVERVIEW (Model model) {
        LOGGER.info("index was called");
        return SALESOVERVIEW;
    }

    @GetMapping("/createoverview.html")
    public String create(Model model) {
        LOGGER.info("create was called... ");
        model.addAttribute("salesoverview", new SalesOverview());
        return CREATEOVERVIEW;
    }

    @RequestMapping("/saveSalesOverview")
    public String saveSalesOverview(@ModelAttribute SalesOverview salesOverview) {
        LOGGER.info("saveSalesOverview was called... ");
        salesOverviewService.createSalesOverview(salesOverview);
        return SALESOVERVIEW;
    }

}