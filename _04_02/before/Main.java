package _04_02.before;

public class Main {

    public static void main(String[] args) {
        Greeting GoodMrng = () -> System.out.println("Good morning");
        GoodMrng.printMessage();
        Greeting GoodAfter = ()-> System.out.println("Good afternoon");
        GoodAfter.printMessage();

    }

}
