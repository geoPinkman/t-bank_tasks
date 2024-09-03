package task10;

import task8.Point;

public class Bows {
    private Point[] topBow;
    private Point[] bottomBow;

    public Bows(Point[] topBow, Point[] bottomBow) {
        this.topBow = topBow;
        this.bottomBow = bottomBow;
    }

    public Bows() {
    }

    public Point[] getTopBow() {
        return topBow;
    }

    public void setTopBow(Point[] topBow) {
        this.topBow = topBow;
    }

    public Point[] getBottomBow() {
        return bottomBow;
    }

    public void setBottomBow(Point[] bottomBow) {
        this.bottomBow = bottomBow;
    }
}
