package task3;

public class Main {

    public static void main(String[] args) {
        int[] firstString = {6, 4};
        int[] secondString = {1,2,3,6,8,25};
        int thirdString = 5;
        System.out.println(CheckConditions.makeWaySeparated(secondString, thirdString, firstString[1]));
    }
}
