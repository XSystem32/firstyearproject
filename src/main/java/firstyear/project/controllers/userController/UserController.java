package firstyear.project.controllers.userController;

import firstyear.project.controllers.salesOverviewController.SalesOverviewController;
import firstyear.project.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.logging.Logger;

@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(SalesOverviewController.class.getName());

    private final String CREATE_USER = "user/createUser.html";
    private final String DELETE_USER = "user/deleteUser.html";
    private final String UPDATE_USER = "user/updateUser.html";
    private final String DISPLAY_USER = "user/User.html";
    private final String DISPLAY_USERS = "user/Users.html";
    private final String REDIRECT_INDEX = "redirect:/";

    @GetMapping("user/createUser")
    public String create(Model model) {
        LOGGER.info("create was called... ");

        return CREATE_USER;
    }
    @GetMapping("user/saveUser")
    public String saveUser(Model model) {
        LOGGER.info("create was called... ");

        return REDIRECT_INDEX;
    }


    @GetMapping("user/deleteUser")
    public String delete(Model model) {
        LOGGER.info("create was called... ");
        return DELETE_USER;
    }

    @GetMapping("user/updateUser")
    public String update(Model model) {
        LOGGER.info("create was called... ");
        return UPDATE_USER;
    }
    @GetMapping("user/displayUser")
    public String display(Model model) {
        LOGGER.info("create was called... ");
        return DISPLAY_USER;
    }

    @GetMapping("user/displayUsers")
    public String displayUsers(Model model) {
        LOGGER.info("create was called... ");

        ArrayList<User> users = new ArrayList<>();

        users.add(new User(1,"ptrprkt","asdf","peter@parker.dk","Peter Parker", "1"));
        users.add(new User(1,"katiee","asdf","katie@parker.dk","Katie Parker", "1"));
        users.add(new User(1,"coolcat","asdf","catt@parker.dk","Frank Black", "1"));


        model.addAttribute("users", users);
        return DISPLAY_USERS;
    }

}
