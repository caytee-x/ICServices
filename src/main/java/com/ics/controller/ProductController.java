package com.ics.controller;
import com.ics.models.Account;
import com.ics.models.AuthUser;
import com.ics.models.User;
import com.ics.repo.AccountRepo;
import com.ics.repo.AuthUserRepo;
import com.ics.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AuthUserRepo authRepo;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({"/products"})
    public ModelAndView getAllProducts(){

        AuthUser user = authRepo.findTopByOrderByIdDesc();
        String fps = user.getFps();
        Account account =  accountRepo.findByFps(fps);

        ModelAndView mav = new ModelAndView("products");
        mav.addObject("products", productRepository.findAll());
        mav.addObject("account", account);
        return mav;
    }

}
