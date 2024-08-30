package com.example.springdemo.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/index.kdt")
    public String index(Model model) {
        System.out.println("debug >>> ");
        model.addAttribute("msg", "하이용");
        return "index";
    }

}
