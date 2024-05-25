package section02.javabasic;

public class MorningGreet implements Greet {
    @Override
    public void greeting() {
        System.out.println("좋은아침!");
    }
}
