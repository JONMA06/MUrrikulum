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
}
