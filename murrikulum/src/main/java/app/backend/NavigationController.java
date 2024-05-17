package app.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/saioa_hasi")
    public String saioaHasi() {
        return "login"; 
    }

    @GetMapping("/izena_eman")
    public String izenaEman() {
        return "register"; 
    }
    @GetMapping("/saioa_amaitu")
    public String saioaAmaitu() {
        return "home"; 
    }
}
