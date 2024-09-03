package task11;

public class Calculate {

    private int l;
    private int r;
    private int p;

    public Calculate(int l, int r, int p) {
        this.l = l;
        this.r = r;
        this.p = p;
    }

    public int getX(int i, int p) {
        int modP = p;
        int x = (p + 1) / i;
        while ((p + 1) % i != 0) {
            p += modP;
            x = (p + 1) / i;
        }
        return x % p;
    }

    public int getResult() {
        int res = 0;
        for (int i = this.l; i <= this.r ; i++) {
            res += getX(i, this.p);
        }
        return res % this.p;
    }





}
