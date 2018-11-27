package firstyear.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SalesOverviewController {


    @GetMapping("/create.html")
    public String create(Model model, Model genreDisplay, Model actorDisplay){
        LOGGER.info("create was called... ");
        model.addAttribute("salesoverview", new Salesoverview());
        genreDisplay.addAttribute("genres", genreController.genreService.getGenres());
        actorDisplay.addAttribute("actors", actorController.actorService.getActors());
        return CREATE;
    }

    @RequestMapping("/saveMovie")
    public String saveMovie(@ModelAttribute Movie movie){
        LOGGER.info("saveMovie was called... ");
        System.out.println(movie);
        movieService.createMovie(movie);
        return REDIRECT_INDEX;

    }

