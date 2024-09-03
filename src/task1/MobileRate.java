package task1;

public class MobileRate {

    public static final int MIN = 1;
    public static final int MAX = 100;

    private final int basePrice;
    private final int baseValue;
    private final int overPrice;

    public MobileRate(int basePrice, int baseValue, int overPrice) {
        this.basePrice = basePrice;
        this.baseValue = baseValue;
        this.overPrice = overPrice;
    }

    public MobileRate mobileRate() {
        if (
                basePrice >= MIN && basePrice <= MAX
                && baseValue >= MIN && baseValue <= MAX
                && overPrice >= MIN && overPrice <= MAX
        )
        return new MobileRate(basePrice, baseValue, overPrice);
        else throw new RuntimeException();
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public int getOverPrice() {
        return overPrice;
    }
}
