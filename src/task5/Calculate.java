package task5;

public class Calculate {
    
    private long firstVariable;
    private long secondVariable;

    public static final int MAX_AVAILABLE_COUNT = 9;

    public Calculate(long firstVariable, long secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    private long convertStringToLong(String input) {
        return Long.parseLong(input);
    }

    private String convertLongToString(long input) {
        return String.valueOf(input);
    }

    private long getDivider(int multiple) {
        String res = "";
        for (int i = 0; i < multiple; i++) {
            res += "1";
        }
        return convertStringToLong(res);
    }

    private long getMaxValueOfMultiple(int multiple) {
        return getDivider(multiple) * MAX_AVAILABLE_COUNT;
    }

    private long getMinValueOfMultiple(int multiple) {
        String res = "1";
        for (int i = 0; i < multiple; i++) {
            res += "0";
        }
        return convertStringToLong(res);
    }

    private int getMultiple(long anyData) {
        String str = convertLongToString(anyData);
        return str.length();
    }

    private int getCount(long b, long a, int multiple) {
        int res = 0;
        long divider = getDivider(multiple);
        long step = divider;
        while (a >= divider) {
            if (a == divider) {
                res += 1;
            }
            divider += step;
        }
        while (b >= divider) {
            divider += step;
            res += 1;
        }
        return res;
    }

    public int getResult() {
        int result;
        int multipleFirst = getMultiple(this.firstVariable);
        int multipleSecond = getMultiple(this.secondVariable);

        int multipleDelta = multipleSecond - multipleFirst;

        if (multipleDelta == 0) {
            result = getCount(this.secondVariable, this.firstVariable, multipleFirst);
            return result;
        }
        else {
            int resultOfFullDecade = (multipleDelta - 1) * MAX_AVAILABLE_COUNT;
            long newSecondVariable = getMaxValueOfMultiple(multipleFirst);
            result = getCount(newSecondVariable, this.firstVariable, multipleFirst);
            long newFirstVariable = getMinValueOfMultiple(multipleSecond);
            result += getCount(this.secondVariable, newFirstVariable, multipleSecond);
            return result + resultOfFullDecade;
        }
    }
}
