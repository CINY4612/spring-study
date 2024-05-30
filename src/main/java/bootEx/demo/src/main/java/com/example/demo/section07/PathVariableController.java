package com.example.demo.section07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PathVariableController {
    @GetMapping("show/path")
    public String showView() {
        return "show_path";
    }

    @GetMapping("/function/{no}")
    public String selectFunction(@PathVariable Integer no) {
        String view = null;
        switch (no) {
            case 1:
                view = "pathvariable/function1";
                break;
            case 2:
                view = "pathvariable/function2";
                break;
            case 3:
                view = "pathvariable/function3";
                break;
            default:
                throw new IllegalArgumentException("잘못된 number");
        }

        return view;
    }

    @PostMapping(value = "send", params = "one")
    public String showViewOne() {
        return "submit/one";
    }

    @PostMapping(value = "send", params = "two")
    public String showViewTwo() {
        return "submit/two";
    }

    @PostMapping(value = "send", params = "three")
    public String showViewThree() {
        return "submit/three";
    }
}
