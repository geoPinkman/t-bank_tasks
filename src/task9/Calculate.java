package task9;

import java.util.Arrays;

public class Calculate {

    public int getOptimal(int[] ar) {
        int res = 0;
        int resFreeLunch = 0;
        int count = 0;
        int[] newAr = new int[0];
        for (int j : ar) {
            if (j > 100) {
                count += 1;
                resFreeLunch += j;
            } else {
                newAr = Arrays.copyOf(newAr, newAr.length + 1);
                newAr[newAr.length - 1] = j;
            }
        }
        Arrays.sort(newAr);
        for (int i = 0; i < newAr.length - count; i++) {
            res += newAr[i];
        }
        return res + resFreeLunch;
    }

}
