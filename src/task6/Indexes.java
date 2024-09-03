package task6;

public class Indexes {

    private int firstIndex;
    private int secondIndex;

    @Override
    public String toString() {
        return "Indexes{" +
                "firstIndex=" + firstIndex +
                ", secondIndex=" + secondIndex +
                '}';
    }

    public Indexes() {
        this.firstIndex = -1;
        this.secondIndex = -1;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }
}
