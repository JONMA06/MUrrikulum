package app.backend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.backend.model.Enpresa;
import app.backend.model.User;
import app.backend.repository.EnpresaRepository;
import app.backend.repository.UserRepository;

@Controller
public class NavigationController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EnpresaRepository enpresaRepository;

    @GetMapping("/saioa_hasi")
    public String saioaHasi() {
        return "login";
    }

    @GetMapping("/izena_eman")
    public String izenaEman() {
        return "register";
    }

    @GetMapping("/saioa_amaitu")
    public String saioaAmaitu(Model model) {
        model.addAttribute("user_role", null);
        model.addAttribute("helburua", null);
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<User> userOptional = userRepository.findByErabiltzaileaAndPasahitza(username, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user_role", user.getRola());

            if ("enpresa".equals(user.getRola())) {
                Optional<Enpresa> enpresaOptional = enpresaRepository.findByUserId(user.getId());
                if (enpresaOptional.isPresent()) {
                    Enpresa enpresa = enpresaOptional.get();
                    model.addAttribute("helburua", enpresa.getHelburua());
                }
            }
            model.addAttribute("notloged", false);
            return "home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}
