package app.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/saioa_amaitu")
    public String saioaAmaitu() {
        return "home"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = UserRepository.findByErabiltzaileaAndPasahitza(username, password);
        if (user != null) {
            // Usuario autenticado correctamente
            return "redirect:/home";
        } else {
            // Credenciales inválidas, mostrar mensaje de error
            model.addAttribute("error", true);
            return "login";
        }
    }
}
