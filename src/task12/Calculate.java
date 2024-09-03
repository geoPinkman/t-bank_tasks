package task12;

import java.util.Arrays;

public class Calculate {

    private final int maxSum;

    public Calculate(int maxSum) {
        this.maxSum = maxSum;
    }

    public int getResult(int firstCoin, int secondCoin, int thirdCoin) {
        int res = 1;
        int [] coins = {firstCoin, secondCoin, thirdCoin};
        int [] factors = new int[coins.length];
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            int factor = (this.maxSum - 1) / coins[i];
            factors[i] = factor;
            res += factor;
        }
        res += getMaxSumCount(firstCoin, secondCoin, factors[1]);
        res += getMaxSumCount(secondCoin, thirdCoin, factors[2]);
        res += getMaxSumCount(thirdCoin, firstCoin, factors[0]);

        return res;
    }

    public int getMaxSumCount(int firstCoin, int secondCoin, int secondFactor) {
        int res = 0;

        while (secondFactor - 1 >= 0) {
            int compare = (this.maxSum - 1) - (secondCoin * secondFactor);
            res += compare / firstCoin;
            secondFactor--;
        }
        return res;
    }

}
