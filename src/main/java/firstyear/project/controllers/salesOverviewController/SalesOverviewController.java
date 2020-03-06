package firstyear.project.controllers.salesOverviewController;

import firstyear.project.models.SalesOverview;
import firstyear.project.services.SalesOverviewService;
import org.apache.tomcat.jni.Local;
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

    private final String INDEX = "salesoverview/index.html";
    private final String CREATEOVERVIEW = "salesoverview/createoverview.html";
    private final String REDIRECT_SALESOVERVIEW = "redirect:/salesoverview";
    private final String UPDATESALESOVERVIEW = "salesoverview/update.html";
    private final String DISPLAYSALESOVERVIEW = "salesoverview/display.html";



    @GetMapping("/salesoverview")
    public String index (Model model) {
        LOGGER.info("index was called");

        LocalDate month = LocalDate.now();

        model.addAttribute("currentMonth", month);

        LocalDate end = LocalDate.now();
        LocalDate start = end.minusMonths(1);

        List<SalesOverview> salesOverviews = salesOverviewService.getSalesOverviews(LocalDate.from(start) ,LocalDate.now());
        model.addAttribute("salesoverviews", salesOverviews);
        return INDEX;
    }


    @GetMapping("salesoverview/createoverview")
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

    @RequestMapping(value = "/deleteSalesOverview", method = RequestMethod.GET)
    public String deleteSalesOverview(@RequestParam(name="id")String id){
        LOGGER.info("Delete movie was called" + id);
        salesOverviewService.deleteSalesOverview(Integer.parseInt(id));
        return REDIRECT_SALESOVERVIEW;
    }

    @RequestMapping(value = "/updateSalesOverview", method = RequestMethod.GET)
    public String updateSalesOverview(@RequestParam(name = "id") String id, Model model) {
        LOGGER.info("updateSalesOverview action called... " + id);
        model.addAttribute("salesoverview", salesOverviewService.getSalesOverview(Integer.parseInt(id)));
        return UPDATESALESOVERVIEW;
    }

    @RequestMapping("/updateSalesOverviewSubmit")
    public String updateSalesOverview(@ModelAttribute SalesOverview salesOverview) {
        LOGGER.info("updateSalesOverviewSubmit was called");
        salesOverviewService.updateSalesOverview(salesOverview);
        return REDIRECT_SALESOVERVIEW;
    }

    @RequestMapping(value = "/displaySalesOverview", method = RequestMethod.GET)
    public String displaySalesOverview(@RequestParam(name="id")String id, Model model){
        LOGGER.info("Display salesoverview was called" + id);
        SalesOverview salesOverview = salesOverviewService.getSalesOverview(Integer.parseInt(id));
        model.addAttribute("salesoverview", salesOverview);
        return DISPLAYSALESOVERVIEW;
    }

}
jajajaja