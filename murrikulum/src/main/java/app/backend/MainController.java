package app.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.backend.model.Course;
import app.backend.model.Position;
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
            List<Position> positions = loadPositionsFromDatabase(); 
            model.addAttribute("positions", positions);
            List<Course> courses = loadCoursesFromDatabase(); 
            model.addAttribute("courses", courses);
            return "myWorkspace";
        } else {
            model.addAttribute("notloged", true);
            return "login";
        }
    }
    //TODO falta la base de datos de los lanpostus
    private List<Position> loadPositionsFromDatabase() {
        List<Position> positions = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Position position = new Position("Lan izena"+i,"Enpresa Izena"+i, "Lokalidadea"+i, "Soldata"+i, "Sektorea"+i, "Hizkuntza"+i, "Beharrezko Hezkuntza"+i, "Online"+i);

            positions.add(position);
        }
        return positions;
    }

    //TODO falta la base de datos de los lanpostus
    private List<Course> loadCoursesFromDatabase() {
        List<Course> courses = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Course course = new Course(
            "Default Course"+i, // Kurtso izena por defecto
            "Default Location"+i, // Lokalitatea por defecto
            "Default Sector"+i, // Sektorea por defecto
            "Default Language"+i, // Hizkuntza por defecto
            "Default Mode"+i, // Modua por defecto
            "Default Difficulty"+i, // Difficulty por defecto
            "Default Length"+i, // Length por defecto
            i % 5 + 1 // Rating por defecto (1 a 5)
        );

            courses.add(course);
        }
        return courses;
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
