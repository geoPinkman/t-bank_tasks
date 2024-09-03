package task3;

public class CheckConditions {

    public static boolean isTimeEnough(int wayLength, int timeOut) {
        return timeOut >= wayLength;
    }

    public static int makeWaySeparated(int[] route, int employerIndex, int timeOut) {
        int wayBeforeIndex = 0;
        int wayAfterIndex = 0;
        for (int i = 0; i < route.length - 1; i++) {
            if (i < employerIndex - 1) {
                wayBeforeIndex += (route[i + 1] - route[i]);
            }   else {
                wayAfterIndex += (route[i + 1] - route[i]);
            }
        }
        if (wayBeforeIndex < wayAfterIndex) {
            if (isTimeEnough(wayBeforeIndex, timeOut)) {
                return wayBeforeIndex + wayAfterIndex;
            } else {
                return wayBeforeIndex * 2 + wayAfterIndex;
            }
        } else {
            if (isTimeEnough(wayAfterIndex, timeOut)) {
                return wayBeforeIndex + wayAfterIndex;
            } else {
                return wayAfterIndex * 2 + wayBeforeIndex;
            }
        }
    }
}
