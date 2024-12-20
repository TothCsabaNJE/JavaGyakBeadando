package com.example.gyakorlatbeadando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;

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

    @Autowired private KapcsolatRepository kapcsolatRepository;
    @GetMapping("/admin/home")
    public String admin(Model model) {
        model.addAttribute("kapcsolat", kapcsolatRepository.findAllBackwards());
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
    public String feedback(Model model) {
        model.addAttribute("kapcsolat", new Kapcsolat());
        return "feedback";
    }


    @PostMapping("/feedback_process")
    public String feedbackProcess(@Valid @ModelAttribute Kapcsolat kapcsolat, Model model) {
        if(bindingResult.hasErrors()){
            return "feedback";
        }
        kapcsolat.setDate(new Date(System.currentTimeMillis()));
        kapcsolatRepository.save(kapcsolat);
        model.addAttribute("uzenet", kapcsolat.getUzenet());
        model.addAttribute("kuldo", kapcsolat.getKuldo());
        return "feedbacksuccess";
    }
}

