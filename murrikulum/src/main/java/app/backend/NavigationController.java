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
import jakarta.servlet.http.HttpSession;

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
    public String saioaAmaitu(HttpSession session, Model model) {
        session.invalidate(); // Invalida la sesión actual
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        Optional<User> userOptional = userRepository.findByErabiltzaileaAndPasahitza(username, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            session.setAttribute("user_role", user.getRola());

            if ("enpresa".equals(user.getRola())) {
                Optional<Enpresa> enpresaOptional = enpresaRepository.findByUserId(user.getId());
                if (enpresaOptional.isPresent()) {
                    Enpresa enpresa = enpresaOptional.get();
                    session.setAttribute("helburua", enpresa.getHelburua());
                }
            }
            session.setAttribute("notloged", false);
            return "home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}
