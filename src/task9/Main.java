package task9;

public class Main {

    public static void main(String[] args) {
        int [] ar = {5,35,40,101,59,63};

        Calculate calculate = new Calculate();

        System.out.println(calculate.getOptimal(ar));
    }
}
