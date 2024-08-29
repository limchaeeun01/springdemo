package com.example.springdemo.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springdemo.test.domain.BbsResponseDTO;

@Controller
public class TestController {

    @RequestMapping("/index.kdt")
    public String index(Model model) {
        System.out.println("debug >>> ");
        model.addAttribute("msg", "하이용");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/api/bbs/ctrl/test", method = RequestMethod.GET)
    public BbsResponseDTO test() {
        BbsResponseDTO response = BbsResponseDTO.builder()
                .id(1)
                .title("test")
                .content("test")
                .build();

        return response;
    }

}
