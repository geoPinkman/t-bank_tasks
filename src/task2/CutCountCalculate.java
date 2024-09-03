package task2;

public class CutCountCalculate {

    public static int calculate(int count) {
        int i = 0;
        while (true) {
            int button = (int)Math.pow(2, i);
            int top = (int)Math.pow(2, ++i);
            if (button < count && count <= top) {
                return i;
            }
        }
    }
}
