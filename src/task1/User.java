package task1;

public class User {

    public static final int MIN = 1;
    public static final int MAX = 100;

    private final int spendValue;

    public User(int spendValue) {
        this.spendValue = spendValue;
    }

    public User user() {
        if (spendValue >= MIN && spendValue <= MAX) {
            return new User(spendValue);
        } else {
            throw new RuntimeException();
        }
    }

    public int getSpendValue() {
        return spendValue;
    }
}
