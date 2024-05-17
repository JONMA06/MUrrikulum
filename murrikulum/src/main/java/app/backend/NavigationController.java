package app.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import app.backend.model.User;
import app.backend.repository.UserRepository;

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

    
}
