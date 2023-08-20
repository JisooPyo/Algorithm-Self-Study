package programmers.test2306.test230624;

import java.util.Arrays;

public class ImplementArrayAlignment {
    public static void main(String[] args) {
        ImplementArrayAlignment iaa = new ImplementArrayAlignment();
        int[] t1 = {4, 3, 7, 5, 0};
        int[] t2 = {3, 1, 9, 0, 8};

        System.out.println(Arrays.toString(iaa.sort(t1)));
        System.out.println(Arrays.toString(iaa.sort(t2)));
        Arrays.sort(t1);


    }

    public int[] sort(int[] test) {
        while (true) {
            int[] beforetest = Arrays.copyOf(test, test.length);
            for (int i = 0; i < test.length - 1; i++) {
                if (test[i] > test[i + 1]) {
                    int temp = test[i];
                    test[i] = test[i + 1];
                    test[i + 1] = temp;
                }
            }
            int[] aftertest = Arrays.copyOf(test, test.length);
            if (Arrays.equals(beforetest, aftertest)) {
                return test;
            }
        }
    }
}
