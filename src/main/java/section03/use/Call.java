package section03.use;

import section03.used.*;

public class Call {
    public static void main(String[] args) {
        // 일반 클래스로 구현한 경우
        CalculatorAdd calculatorAdd = new CalculatorAdd();
        System.out.println(calculatorAdd.add(1, 2));
        CalculatorSub calculatorSub = new CalculatorSub();
        System.out.println(calculatorSub.sub(3, 4));
        // 더하기 기능을 새로운 sub 클래스로 변경할 경우, 생성부와 메소드 선언부 모두 수정해야 함

        // 인터페이스에 의존하는 경우
        Calculator addCal = new AddCal();
        System.out.println(addCal.calc(1, 2));
        Calculator subCal = new SubCalc();
        System.out.println(subCal.calc(3, 4));
        // 더하기 기능을 변경할 경우, 생성부만 변경하면 됨
    }
}
