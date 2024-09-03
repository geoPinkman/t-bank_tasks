package task10;

import task8.Point;
import task8.Util;
import java.util.Arrays;
import java.util.Comparator;

public class Calculate {

    private final GraphFunc graphFunc = new GraphFunc();

    private void correctPositionOfFigureByOy(Point[] ar) {
        double minY = Arrays.stream(ar)
                .min(Comparator.comparingDouble(Point::getY))
                .get()
                .getY();
        if (minY < 0) {
            minY = Math.abs(minY);
            for (Point point : ar) {
                point.setY(point.getY() + minY);
            }
        }
    }

    private Point[] sortPointsByX(Point[] ar) {
        return Arrays.stream(ar)
                .sorted(Comparator.comparingDouble(Point::getX))
                .toArray(Point[]::new);
    }

    public Bows getBows(Point[] ar) {
        correctPositionOfFigureByOy(ar);
        ar = sortPointsByX(ar);
        Point min = ar[0];
        Point max = ar[ar.length - 1];
        Point[] bottom = new Point[1], top = new Point[1];
        bottom[0] = min;
        top[0] = min;

        double kMainLine = graphFunc.getK(min, max);
        double bMainLine = graphFunc.getB(min, max);

        for (int i = 1; i < ar.length - 1; i++) {
             Point currentPoint = ar[i];
             double y = kMainLine * currentPoint.getX() + bMainLine;
             if (currentPoint.getY() > y) {
                 top = Arrays.copyOf(top, top.length + 1);
                 top[top.length - 1] = currentPoint;
             }
             else {
                 bottom = Arrays.copyOf(bottom, bottom.length + 1);
                 bottom[bottom.length - 1] = currentPoint;
             }
        }
        top = Arrays.copyOf(top, top.length + 1);
        bottom = Arrays.copyOf(bottom, bottom.length + 1);
        top[top.length - 1] = max;
        bottom[bottom.length - 1] = max;

        return new Bows(top, bottom);
    }

    public Bows makeBowsWithSymmetricPoints(Bows bows) {
        Point currentI, currentJ, nextJ;
        Point[] bottom = bows.getBottomBow();
        Point[] top = bows.getTopBow();
        for (int i = 1; i < bows.getTopBow().length - 1; i++) {
            currentI = bows.getTopBow()[i];
            for (int j = 0; j < bows.getBottomBow().length - 1; j++) {
                currentJ = bows.getBottomBow()[j];
                nextJ = bows.getBottomBow()[j + 1];
                bottom = getPoints(currentI, currentJ, nextJ, bottom);
            }
        }
        for (int i = 1; i < bows.getBottomBow().length - 1 ; i++) {
            currentI = bows.getBottomBow()[i];
            for (int j = 0; j < bows.getTopBow().length - 1; j++) {
                currentJ = bows.getTopBow()[j];
                nextJ = bows.getTopBow()[j + 1];
                top = getPoints(currentI, currentJ, nextJ, top);
            }
        }
        return new Bows(sortPointsByX(top), sortPointsByX(bottom));
    }

    private Point[] getPoints(Point currentI, Point currentJ, Point nextJ, Point[] top) {
        if (currentI.getX() > currentJ.getX() && currentI.getX() < nextJ.getX()) {
            double k = graphFunc.getK(currentJ, nextJ);
            double b = graphFunc.getB(currentJ, nextJ);
            Point omp = new Point(currentI.getX(), k * currentI.getX() + b);
            top = Arrays.copyOf(top, top.length + 1);
            top[top.length - 1] = omp;
        }
        return top;
    }

    public double[] getBowSquares(Point[] ar) {
        double[] res = new double[ar.length - 1];
        Point currP, nextP;
        for (int i = 0; i < ar.length - 1; i++) {
            currP = ar[i];
            nextP = ar[i + 1];
            double square = graphFunc.getSquare(currP, nextP);
            res[i] = square;
        }
        return res;
    }

    public double getPointOfHalfFigure(Point[] ar) {
        Bows bows = getBows(ar);
        bows = makeBowsWithSymmetricPoints(bows);
        Point[] topBow = bows.getTopBow();
        Point[] bottomBow = bows.getBottomBow();
        double[] topBowSquares = getBowSquares(topBow);
        double[] bottomBowSquares = getBowSquares(bottomBow);
        double sumTopSquares = Arrays.stream(topBowSquares).sum();
        double sumBottomSquares = Arrays.stream(bottomBowSquares).sum();
        double resultSquare = sumTopSquares - sumBottomSquares;

        int topCount = 0, bottomCount = 0;
        double currentSumsOfSq = 0;
        PointPair top, bottom;
        double sqBeforeHalf, sqAfterHalf;

        while (true) {
            double currentTopSq = topBowSquares[topCount];
            double currentBottomSq = bottomBowSquares[bottomCount];
            if(currentTopSq == 0.0) {
                topCount++;
                currentTopSq = topBowSquares[topCount];
            }
            if(currentBottomSq == 0.0) {
                bottomCount++;
                currentBottomSq = bottomBowSquares[bottomCount];
            }
            double currentS = currentTopSq - currentBottomSq;
            currentSumsOfSq += currentS;
            if (currentSumsOfSq >= resultSquare / 2) {
                top = new PointPair(topBow[topCount], topBow[topCount + 1]);
                bottom = new PointPair(bottomBow[bottomCount], bottomBow[bottomCount + 1]);
                sqBeforeHalf = currentSumsOfSq - currentS;
                sqAfterHalf  = resultSquare - currentSumsOfSq;
                if (currentSumsOfSq == resultSquare / 2) {
                    return Util.roundValue(topBow[topCount + 1].getX());
                }
                break;
            }
            topCount++;
            bottomCount++;
        }
        return Util.roundValue(graphFunc.findX(sqBeforeHalf, sqAfterHalf,
                top.getFirstPoint(), top.getSecondPoint(),
                bottom.getFirstPoint(), bottom.getSecondPoint()));
    }

}
