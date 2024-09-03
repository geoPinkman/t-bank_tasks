package task8;

public class Util {
    public static Point getCoordinatesOfMiddleLength(Point a, Point b) {
        double x, y;
        x = (a.getX() + b.getX()) / 2;
        y = (a.getY() + b.getY()) / 2;
        return new Point(x, y);
    }

    public static double roundValue(double input) {
        String str = String.format("%.5f", input)
                .replace(",", ".");
        input = Double.parseDouble(str);
        return input;
    }
}
