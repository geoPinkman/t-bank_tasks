package task8;

public class Room {

    private Point leftBottom;
    private Point rightBottom;
    private Point rightTop;
    private Point leftTop;

    public Room(Point leftBottom, Point rightBottom, Point rightTop, Point leftTop) {
        this.leftBottom = leftBottom;
        this.rightBottom = rightBottom;
        this.rightTop = rightTop;
        this.leftTop = leftTop;
    }

    public Point getLeftBottom() {
        return leftBottom;
    }

    public void setLeftBottom(Point leftBottom) {
        this.leftBottom = leftBottom;
    }

    public Point getRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(Point rightBottom) {
        this.rightBottom = rightBottom;
    }

    public Point getRightTop() {
        return rightTop;
    }

    public void setRightTop(Point rightTop) {
        this.rightTop = rightTop;
    }

    public Point getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(Point leftTop) {
        this.leftTop = leftTop;
    }

    @Override
    public String toString() {
        return "Room{" +
                "leftBottom=" + leftBottom +
                ", rightBottom=" + rightBottom +
                ", rightTop=" + rightTop +
                ", leftTop=" + leftTop +
                '}';
    }

}
