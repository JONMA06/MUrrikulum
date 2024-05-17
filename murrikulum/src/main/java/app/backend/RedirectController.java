package app.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping(value = {"/", "/etxea"})
    public String redirectHome() {
        return "home";
    }
    @GetMapping("/bilatuLanpostua")
    public String redirectBilatuLana() {
        return "findJob";
    }
    @GetMapping("/bilatuKurtsoa")
    public String redirectBilatuKurtsoa() {
        return "findCourse";
    }
    @GetMapping("/txat")
    public String redirectTxat() {
        return "chat";
    }
    @GetMapping("/lanEremua")
    public String redirectLanEremua() {
        return "myWorkspace";
    }
    @GetMapping("/lanpostuBerria")
    public String redirectLanpostuBerria() {
        return "newWorkOffer";
    }
    @GetMapping("/kurtsoBerria")
    public String redirectKurtsoBerria() {
        return "newCourseOffer";
    }
    @GetMapping("/enpresakoLanpostuak")
    public String redirectEnpresakoLanpostuak() {
        return "companiesWorks";
    }
    @GetMapping("/enpresakoKurtsoak")
    public String redirectEnpresakoKurtsoak() {
        return "companiesCourses";
    }
}
