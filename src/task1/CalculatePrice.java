package task1;

public class CalculatePrice {

    public static int calculate(int basePrice, int baseValue, int overPrice, int spendValue) {
        MobileRate mobileRate = new MobileRate(basePrice, baseValue, overPrice).mobileRate();
        User user = new User(spendValue).user();
        int result;
        if (mobileRate.getBaseValue() > user.getSpendValue()) {
            result = mobileRate.getBasePrice();
        } else {
            int overValue = user.getSpendValue() - mobileRate.getBaseValue();
            result = mobileRate.getBasePrice() + mobileRate.getOverPrice() * overValue;
        }
        return result;
    }
}
