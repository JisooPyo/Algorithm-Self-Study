package leetcode.explore.arrayAndString;

import java.util.Arrays;

public class ArrayAndString10 {
    public static void main(String[] args) {
        ArrayAndString10 aas10 = new ArrayAndString10();

        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        // ['o','l','l','e','h']

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        // ['h','a','n','n','a','H']

        aas10.reverseString(s1);
        aas10.reverseString(s2);

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

}
