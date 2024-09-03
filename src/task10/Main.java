package task10;

import task8.Point;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();

        Point p1 = new Point(2,3);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(6,3);
        Point p7 = new Point(4, 2);
        Point p4 = new Point(2, 2.5);
        Point p5 = new Point(3  ,1);
        Point p6 = new Point(2,2);

        Point[] points = {p1,p2,p3,p7,p4};//,p4,p5,p6};
        System.out.println(calculate.getPointOfHalfFigure(points));

    }


}
