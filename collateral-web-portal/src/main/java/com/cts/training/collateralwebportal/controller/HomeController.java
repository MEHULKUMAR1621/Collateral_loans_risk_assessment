package com.cts.training.collateralwebportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView homePage(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
    
    @GetMapping("/homecustomer")
    public ModelAndView homePageCustomer(){
        ModelAndView mv = new ModelAndView("homecustomer");
        return mv;
    }
	
    
}
