package task6;

public class Calculate {

    public boolean isArrayValid(int[] ar) {
        int length = ar.length;
        int even = 0;
        int odd = 0;
        for (int j : ar) {
            if (j % 2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        return (length % 2 != 0 && odd - even == 1)
                || (length % 2 == 0 && even == odd);
    }

    public Indexes test(int [] ar) {
        Indexes indexes = new Indexes();
        if (isArrayValid(ar)) {
            int[] a = ar;
            int wrongIntFirst;
            for (int i = 0; i < ar.length; i++) {
                if (a[i] % 2 == 0 && i % 2 == 0) {
                    indexes.setFirstIndex(i + 1);
                    wrongIntFirst = ar[i];
                    for (int j = i + 1; j < ar.length; j++) {
                        if (a[j] % 2 != 0 && j % 2 !=0) {
                            indexes.setSecondIndex(j + 1);
                            a[i]= ar[j];
                            a[j] = wrongIntFirst;
                            break;
                        }
                    }
                }
            }
        }
        return indexes;
    }

}
