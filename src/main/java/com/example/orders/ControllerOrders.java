package com.example.orders;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerOrders {

    @GetMapping("index")
    public String index(){
        return "index";
    }

}
