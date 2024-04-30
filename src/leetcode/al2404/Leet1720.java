package leetcode.al2404;

import java.util.Arrays;

public class Leet1720 {
    public static void main(String[] args) {
        Leet1720 l = new Leet1720();

        int[] encoded1 = {1, 2, 3};
        int[] encoded2 = {6, 2, 7, 3};

        // [1, 0, 2, 1]
        System.out.println(Arrays.toString(l.decode(encoded1, 1)));
        // [4, 2, 0, 7, 4]
        System.out.println(Arrays.toString(l.decode(encoded2, 4)));
    }

    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 1; i < decoded.length; i++) {
            decoded[i] = decoded[i - 1] ^ encoded[i - 1];
        }
        return decoded;
    }
}
