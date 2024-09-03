package task4;

import java.util.Arrays;

public class CalculateLists {

    private int n;
    private int k;
    private long[] list;

    public CalculateLists(int n, int k) {
        this.n = n;
        this.k = k;
        this.list = new long[n];
    }

    public long[] getList() {
        return list;
    }

    public void addElement(long element, int index) {
        this.list[index] = element;
    }

    public long getListSum() {
        return Arrays.stream(this.list).sum();
    }

    public void updateList(long newElement, int indexOldElement) {
        this.list[indexOldElement - 1] = newElement;
    }

    public boolean equalSums(long oldListSum, long newListSum) {
        return newListSum > oldListSum;
    }
}
