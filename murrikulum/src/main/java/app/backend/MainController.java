package app.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping({"/", "/etxea"})
    public String home(Model model, HttpSession session) {
        return "home";
    }

    @GetMapping("/bilatuLanpostua")
    public String redirectBilatuLanpostua(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        if (userRole == null || "arrunta".equals(userRole)) {
            return "findJob";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/bilatuKurtsoa")
    public String redirectBilatuKurtsoa(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        if (userRole == null || "arrunta".equals(userRole) || "enpresa".equals(userRole)) {
            return "findCourse";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/lanEremua")
    public String redirectLanEremua(HttpSession session, Model model) {
        if ("arrunta".equals(session.getAttribute("user_role"))) {
            return "myWorkspace";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/lanpostuBerria")
    public String redirectLanpostuBerria(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        Integer helburua = (Integer) session.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 1 || helburua == 3)) {
            return "newJob";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/enpresakoLanpostuak")
    public String redirectEnpresakoLanpostuak(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        Integer helburua = (Integer) session.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 1 || helburua == 3)) {
            return "companyJobs";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/kurtsoaBerria")
    public String redirectKurtsoaBerria(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        Integer helburua = (Integer) session.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 2 || helburua == 3)) {
            return "newCourse";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/enpresakoKurtsoak")
    public String redirectEnpresakoKurtsoak(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        Integer helburua = (Integer) session.getAttribute("helburua");
        if ("enpresa".equals(userRole) && (helburua == 2 || helburua == 3)) {
            return "companyCourses";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/txat")
    public String redirectTxat(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        if ("arrunta".equals(userRole) || "enpresa".equals(userRole)) {
            return "chat";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }

    @GetMapping("/profila")
    public String profile(HttpSession session, Model model) {
        String userRole = (String) session.getAttribute("user_role");
        if ("arrunta".equals(userRole) || "enpresa".equals(userRole)) {
            return "profile";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }
}
