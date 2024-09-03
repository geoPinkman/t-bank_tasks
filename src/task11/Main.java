package task11;

public class Main {

    public static void main(String[] args) {
        Calculate calculate = new Calculate(3,10,31);
        System.out.println(calculate.getResult());

        Calculate calculate1 = new Calculate(1,5,7);
        System.out.println(calculate1.getResult());
    }
}
