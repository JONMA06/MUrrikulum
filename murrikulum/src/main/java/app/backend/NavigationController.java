package app.backend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.backend.model.Enpresa;
import app.backend.model.LanBila;
import app.backend.model.User;
import app.backend.repository.EnpresaRepository;
import app.backend.repository.LanBilaRepository;
import app.backend.repository.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class NavigationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnpresaRepository enpresaRepository;

    @Autowired
    private LanBilaRepository lanBilaRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/saioa_hasi")
    public String saioaHasi() {
        return "login";
    }

    @GetMapping("/izena_eman")
    public String izenaEman() {
        return "register";
    }

    @GetMapping("/izena_eman_enpresa")
    public String izena_eman_enpresa() {
        return "register_company";
    }

    @GetMapping("/saioa_amaitu")
    public String saioaAmaitu(HttpSession session, Model model) {
        session.invalidate(); // Invalida la sesión actual
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
            Model model) {
        Optional<User> userOptional = userRepository.findByErabiltzailea(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPasahitza())) {
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
            }
        }
        model.addAttribute("error", true);
        return "login";
    }

    @PostMapping("/register_arrunta")
    public String registerArrunta(
            HttpSession session,
            @RequestParam String erabiltzailea,
            @RequestParam String pasahitza,
            @RequestParam String izena,
            @RequestParam String abizena,
            @RequestParam String lokalidadea,
            @RequestParam Integer adina,
            @RequestParam String email,
            Model model) {

        Optional<User> existingUser = userRepository.findByErabiltzailea(erabiltzailea);
        if (existingUser.isPresent()) {
            model.addAttribute("errorMessage", "Erabiltzaile izena dagoeneko existitzen da.");
            return "register";
        }

        User user = new User();
        user.setErabiltzailea(erabiltzailea);
        user.setPasahitza(passwordEncoder.encode(pasahitza));
        user.setRola("arrunta");
        userRepository.save(user);

        LanBila lanBila = new LanBila();
        lanBila.setUser(user);
        lanBila.setIzena(izena);
        lanBila.setAbizena(abizena);
        lanBila.setLokalidadea(lokalidadea);
        lanBila.setAdina(adina);
        lanBila.setEmail(email);
        lanBilaRepository.save(lanBila);

        session.setAttribute("user_role", "arrunta");
        session.setAttribute("notloged", false);

        return "home";
    }

    @PostMapping("/register_enpresa")
    public String registerEnpresa(
            HttpSession session,
            @RequestParam String erabiltzailea,
            @RequestParam String pasahitza,
            @RequestParam String enpresa_izena,
            @RequestParam String lokalidadea,
            @RequestParam String NIF,
            @RequestParam String email,
            @RequestParam(required = false) String[] argitaratu,
            Model model) {

        // Check if the username already exists
        Optional<User> existingUser = userRepository.findByErabiltzailea(erabiltzailea);
        if (existingUser.isPresent()) {
            model.addAttribute("errorMessage", "Erabiltzaile izena dagoeneko existitzen da.");
            return "register_company";
        }

        // Create the User object and save it
        User user = new User();
        user.setErabiltzailea(erabiltzailea);
        user.setPasahitza(passwordEncoder.encode(pasahitza));
        user.setRola("enpresa");
        userRepository.save(user);

        // Determine the value of helburua based on the checkboxes
        int helburua = 0;
        if (argitaratu != null) {
            for (String value : argitaratu) {
                helburua += Integer.parseInt(value);
            }
        }

        // Create the Enpresa object and save it
        Enpresa enpresa = new Enpresa();
        enpresa.setUser(user);
        enpresa.setEnpresaIzena(enpresa_izena);
        enpresa.setLokalidadea(lokalidadea);
        enpresa.setNIF(NIF);
        enpresa.setEmail(email);
        enpresa.setHelburua(helburua);
        enpresaRepository.save(enpresa);

        session.setAttribute("user_role", "enpresa");
        session.setAttribute("helburua", helburua);
        session.setAttribute("notloged", false);

        return "home";
    }

}
