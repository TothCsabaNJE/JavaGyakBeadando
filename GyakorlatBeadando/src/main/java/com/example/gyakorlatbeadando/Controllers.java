package com.example.gyakorlatbeadando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/home")
    public String user() {
        return "user";
    }

    @GetMapping("/admin/home")
    public String admin() {
        return "admin";

    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("reg", new User());
        return "register";
    }

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register_process")
    public String registerProcess(@ModelAttribute User user, Model model) {
        for(User compare : userRepository.findAll())
            if(compare.getName().equals(user.getName())){
                model.addAttribute("message", "This username already exists");
                return "regerror";
            }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        model.addAttribute("id", user.getId());
        return "regsuccess";
    }

    @Autowired private SutiRepository sutiRepository;
    @Autowired private ArRepository arRepository;
    @Autowired private TartalomRepository tartalomRepository;
    @GetMapping("/database")
    public String database(Model model) {
        model.addAttribute("suti", sutiRepository.findAll());
        model.addAttribute("ar", arRepository.findAll());
        model.addAttribute("tartalom", tartalomRepository.findAll());
        return "database";
    }



    @GetMapping("/feedback")
    public String feedback() {
        return "feedback";
    }
}

