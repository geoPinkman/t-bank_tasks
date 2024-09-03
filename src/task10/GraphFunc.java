package task10;

import task8.Point;

public class GraphFunc {

    public double getB(Point a, Point b) {
        return a.getY() - getK(a, b) * a.getX();
    }

    public double getK(Point a, Point b) {
        double up, down;
        up = a.getY() - b.getY();
        down = a.getX() - b.getX();
        return up / down;
    }

    public double calculateIntegral(double xOne, double xTwo, double k, double b) {
        return ((k * Math.pow(xTwo, 2.0) - k * Math.pow(xOne, 2.0)) / 2.0)
                + ((b * xTwo) - (b * xOne));
    }

    public double getSquare(Point a, Point b) {
        if(a.getX() == b.getX()) {
            return 0.0;
        } else {
            double k = getK(a, b);
            double B = getB(a, b);
            return calculateIntegral(a.getX(), b.getX(), k, B);}
    }

    public double findX(double squaresBeforeHalf, double squaresAfterHalf,
                                  Point aPUp, Point bPUp,
                                  Point aPDown, Point bPDown) {
        double kUp = getK(aPUp, bPUp);
        double kDown = getK(aPDown, bPDown);
        double bUp = getB(aPUp, bPUp);
        double bDown = getB(aPDown, bPDown);
        double bX = bPUp.getX();
        double aX = aPUp.getX();

        double c = (Math.pow(bX, 2.0) + Math.pow(aX, 2.0)) * (kUp / 2.0 - kDown / 2.0)
                + (bUp - bDown) * (bX + aX)
                + squaresAfterHalf - squaresBeforeHalf;
        double xOne, xTwo;
        if (kUp - kDown == 0.0 && bUp - bDown != 0.0) {
            return c / (2 * (bUp - bDown));
        } else if (bUp - bDown == 0.0 && kUp - kDown != 0.0) {
            return Math.abs(Math.pow((c / (kUp - kDown)), 0.5));
        } else {
            double d = Math.pow(2 * (bUp - bDown), 2) + 4 * (kUp - kDown) * c;
            xOne = (2 * (bDown - bUp) + Math.pow(d, 0.5)) / (2 * (kUp - kDown));

            xTwo = (2 * (bDown - bUp) - Math.pow(d, 0.5)) / (2 * (kUp - kDown));

            if (xOne <= bX && xOne >= aX) {
                return xOne;
            } else {
                return xTwo;
            }
        }
    }

}
