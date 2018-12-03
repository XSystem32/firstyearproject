package firstyear.project.controllers;

import firstyear.project.models.SalesOverview;
import firstyear.project.services.SalesOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class SalesOverviewController {

    @Autowired
    SalesOverviewService salesOverviewService;

    private static final Logger LOGGER = Logger.getLogger(SalesOverviewController.class.getName());

    private String INDEX = "index.html";
    private String CREATEOVERVIEW = "createoverview.html";
    private String SALESOVERVIEWS = "salesoverviews.html";
    private final String REDIRECT_SALESOVERVIEW = "redirect:/salesoverviews.html";



    @GetMapping("/salesoverviews.html")
    public String overview (Model model) {
        LOGGER.info("index was called");

        LocalDate end = LocalDate.now();
        LocalDate start = end.minusMonths(1);

        System.out.println(start);
        List<SalesOverview> salesOverviews = salesOverviewService.getSalesOverviews(LocalDate.from(start) ,LocalDate.now());
        model.addAttribute("salesoverviews", salesOverviews);
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
        SalesOverview so = new SalesOverview();
        so.setComment("/test SO I made to see if this works.");

        salesOverviewService.createSalesOverview(so);
        return INDEX;
    }


    @GetMapping("/createoverview.html")
    public String create(Model model, SalesOverview dateConverter) {
        LOGGER.info("create was called... ");
        model.addAttribute("salesoverview", new SalesOverview());
        if (dateConverter.getDate() == null) {
            dateConverter.setDate(LocalDate.now());
        }
        return CREATEOVERVIEW;
    }

    @RequestMapping("/saveSalesOverview")
    public String saveSalesOverview(@ModelAttribute SalesOverview salesOverview) {
        LOGGER.info("saveSalesOverview was called... ");
        salesOverviewService.createSalesOverview(salesOverview);
        return REDIRECT_SALESOVERVIEW;
    }


}