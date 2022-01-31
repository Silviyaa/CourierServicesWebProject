package com.example.orders;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("Couriers")
public class CourierController {
    @GetMapping("")
    public String Couriers(){
        return "Couriers";
    }
    @GetMapping("/CourierHomePage")
    public ModelAndView CourierHomePage(){
        var mav = new ModelAndView();
        mav.setViewName("CourierActivity/CourierHomePage");
        return mav;
    }
    @RequestMapping(value = "/SignedInCourierAccount", method = RequestMethod.POST)
    public ModelAndView SignedInCourierAccount(@RequestParam String phone, @RequestParam String pass){
        var mav = new ModelAndView();
        mav.setViewName("CourierActivity/SignedInCourierAccount");
        return mav;
    }
}
