package firstyear.project.controllers.userController;

import firstyear.project.controllers.salesOverviewController.SalesOverviewController;

import firstyear.project.models.User;

import firstyear.project.models.SalesOverview;
import firstyear.project.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger LOGGER = Logger.getLogger(SalesOverviewController.class.getName());

    private final String CREATE_USER = "user/createUser.html";
    private final String DELETE_USER = "user/deleteUser.html";
    private final String UPDATE_USER = "user/updateUser.html";
    private final String DISPLAY_USER = "user/User.html";
    private final String DISPLAY_USERS = "user/Users.html";
    private final String REDIRECT_INDEX = "redirect:/";

    @GetMapping("/userTest")
    public String usertest (Model model){
        LOGGER.info("test was called");
        return REDIRECT_INDEX;
    }

    @GetMapping("user/createUser")
    public String create(Model model) {
        LOGGER.info("create was called... ");
        model.addAttribute("user", new User());
        return CREATE_USER;
    }

    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        LOGGER.info("save was called... ");
        userService.createUser(user);
        return REDIRECT_INDEX;
    }


    @RequestMapping(value = "user/deleteUser", method = RequestMethod.GET)
    public String delete(@RequestParam(name="id")String id, Model model) {
        LOGGER.info("delete was called... ");
        userService.deleteUser(Integer.parseInt(id));
        return DISPLAY_USERS;
    }

    @GetMapping("user/updateUser")
    public String update(Model model) {
        LOGGER.info("update was called... ");
        return UPDATE_USER;
    }

    @RequestMapping(value = "user/User", method = RequestMethod.GET)
    public String display(@RequestParam(name="id")String id, Model model) {
        LOGGER.info("display user was called... ");

        User user = userService.getUser(Integer.parseInt(id));

        model.addAttribute("user", user);

        return DISPLAY_USER;
    }

    @GetMapping("user/displayUsers")
    public String displayUsers(Model model) {
        LOGGER.info("display users was called... ");

        List<User> users = userService.getUsers();

        model.addAttribute("users", users);
        return DISPLAY_USERS;
    }

}
