package app.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/etxea")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/bilatuLanpostua")
    public String redirectBilatuLanpostua(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        if (userRole == null || "arrunta".equals(userRole)) {
            return "findJob";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/bilatuKurtsoa")
    public String redirectBilatuKurtsoa(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        if (userRole == null || "arrunta".equals(userRole) || "enpresa".equals(userRole)) {
            return "findCourse";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/lanEremua")
    public String redirectLanEremua(Model model) {
        if ("arrunta".equals(model.getAttribute("user_role"))) {
            return "myWorkspace";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/lanpostuBerria")
    public String redirectLanpostuBerria(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        Integer helburua = (Integer) model.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 1 || helburua == 3)) {
            return "newJob";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/enpresakoLanpostuak")
    public String redirectEnpresakoLanpostuak(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        Integer helburua = (Integer) model.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 1 || helburua == 3)) {
            return "companyJobs";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/kurtsoaBerria")
    public String redirectKurtsoaBerria(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        Integer helburua = (Integer) model.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 2 || helburua == 3)) {
            return "newCourse";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/enpresakoKurtsoak")
    public String redirectEnpresakoKurtsoak(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        Integer helburua = (Integer) model.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 2 || helburua == 3)) {
            return "companyCourses";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/txat")
    public String redirectTxat(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        if ("arrunta".equals(userRole) || "enpresa".equals(userRole)) {
            return "chat";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/profila")
    public String profile(Model model) {
        String userRole = (String) model.getAttribute("user_role");
        if ("arrunta".equals(userRole) || "enpresa".equals(userRole)) {
            return "chat";
        } else {
            model.addAttribute("notloged", true);
            return "profile";
        }
    }
}
