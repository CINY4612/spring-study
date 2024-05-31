package com.example.demo.section08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidatorController {
    /**
     * form 태그에 바인딩되는 Form 클래스 인스턴스 form-backing bean 설정
     *
     * @return
     */
    @ModelAttribute
    public CalcForm setUpForm() {
        return new CalcForm();
    }

    @GetMapping("calc-show")
    public String showView() {
        return "calc/entry";
    }

    @PostMapping("calc")
    public String confirmView(@Validated CalcForm form,
                              BindingResult bindingResult, Model model) {
        // 입력 체크에서 에러가 발생할 경우-실행 결과는 BindingResult 인터페이스에 저장
        if (bindingResult.hasErrors()) {
            return "calc/entry";
        }

        Integer result = form.getLeftNum() + form.getRightNum();

        model.addAttribute("result", result);

        return "calc/confirm";
    }
}
