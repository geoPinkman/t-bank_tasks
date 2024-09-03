package task8;

public class Main {


    public static void main(String[] args) throws Exception {
        Point a = new Point(0,0);
        Point b = new Point(10,0);
        Point c = new Point(10,5);
        Point d = new Point(0,5);

        Room r = new Room(a, b, c, d);

        System.out.println(r);

        a = new Point(3.0,2.5);
        b = new Point(1.0, 2.5);
        c = new Point(1.0, 1.5);
        d = new Point(3.0, 1.5);

        Room rp = new Room(a, b, c, d);

        System.out.println(rp);

        Calculate calculate = new Calculate(r, rp);
        System.out.println(calculate.doCalculate());;
    }
}
