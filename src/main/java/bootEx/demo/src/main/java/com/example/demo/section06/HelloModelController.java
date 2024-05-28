package com.example.demo.section06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {
    @GetMapping("model")
    public String helloView(Model model) {
        // model : 뷰에서 표시할 데이터를 담은 객체
        model.addAttribute("msg", "타임리프");
        return "helloThymeleaf";
    }
}
