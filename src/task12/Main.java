package task12;

public class Main {

    public static void main(String[] args) {

        Calculate calculate = new Calculate(15);
        int res = calculate.getResult(4, 7, 9);
        System.out.println(res);

    }
}
