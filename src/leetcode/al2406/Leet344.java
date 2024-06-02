package leetcode.al2406;

/**
 * Easy
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Leet344 {
    public void reverseString(char[] s) {
        int len = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[len - i];
            s[len - i] = temp;
        }
    }
}
