package leetcode.explore.hashTable;

import java.util.HashSet;
import java.util.Set;

public class HashTable6 {
    public static void main(String[] args) {
        HashTable6 h = new HashTable6();

        System.out.println(h.isHappy(19));
        System.out.println(h.isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<String> result = new HashSet<>();
        String intToStr = Integer.toString(n);
        while (!result.contains(intToStr)) {
            if (intToStr.equals("1")) {
                return true;
            }
            result.add(intToStr);
            intToStr = getSumOfTheSquaresOfDigits(Integer.parseInt(intToStr));
        }
        return false;
    }

    private String getSumOfTheSquaresOfDigits(int strToInt) {
        int sum = 0;
        while (strToInt != 0) {
            sum += (int) Math.pow(strToInt % 10, 2);
            strToInt = strToInt / 10;
        }
        return Integer.toString(sum);
    }
}
