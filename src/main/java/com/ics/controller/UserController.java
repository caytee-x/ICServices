package com.ics.controller;


import com.ics.models.Account;
import com.ics.models.AuthUser;
import com.ics.models.User;
import com.ics.repo.AccountRepo;
import com.ics.repo.AuthUserRepo;
import com.ics.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {


    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AuthUserRepo authRepo;

    @Autowired
    UserRepository repo;

    @RequestMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register_inmate")
    public String processRegister(User user) {
        repo.save(user);

        return "regsuccess";
    }

    @GetMapping("/login")
    public String showLogIn(Model model){
        model.addAttribute("user", new User());

        return "login";
    }


    @RequestMapping("/submit_login")
    public String processLogIn(User user) {
        String fps = user.getFps();
        String password = user.getPassword();

        User u = repo.findByFps(fps, password);

        if (u != null) {
            authRepo.deleteAll();
            AuthUser authUser = new AuthUser();
            authUser.setFps(u.getFps());
            authUser.setFirst_name(u.getFirst_name());
            authUser.setLast_name(u.getLast_name());
            authUser.setCell_num(u.getCell_num());
            authUser.setUnit_num(u.getUnit_num());
            authRepo.save(authUser);

            return "redirect:/home";
        } else {
            return null;
        }
    }

        @GetMapping("/home")
        public String showHome(Model model){

            AuthUser auth = authRepo.findTopByOrderByIdDesc();
            String fps = auth.getFps();
            Account account = accountRepo.findByFps(fps);
            model.addAttribute("account", account);
            model.addAttribute("user", auth);

            return "home";
        }

    @RequestMapping("/logout")
    public String logout(){
        authRepo.deleteAll();
        return "login";
    }






}
