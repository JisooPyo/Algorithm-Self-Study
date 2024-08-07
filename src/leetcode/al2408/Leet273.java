package leetcode.al2408;

import java.util.ArrayList;
import java.util.List;

/**
 * Hard
 * 273. Integer to English Words
 *
 * 음이 아닌 정수 num을 영어 단어로 표현하세요.
 */
public class Leet273 {
    public static void main(String[] args) {
        Leet273 leet273 = new Leet273();
        // "One Hundred Twenty Three"
        System.out.println(leet273.numberToWords(123));
        // "Twelve Thousand Three Hundred Forty Five"
        System.out.println(leet273.numberToWords(12345));
        // "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        System.out.println(leet273.numberToWords(1234567));
    }

    String[] nums = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // 내 풀이 : 3ms
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String[] levels = {"", "Thousand", "Million", "Billion"};

        int level = 0;
        List<StringBuilder> list = new ArrayList<>();
        while (num != 0) {
            StringBuilder temp = new StringBuilder();
            if (num % 1000 == 0) {
                level++;
                num /= 1000;
                continue;
            }
            temp.append(changeToString(num % 1000));
            if (level != 0) {
                temp.append(' ');
                temp.append(levels[level]);
            }
            list.add(temp);
            level++;
            num /= 1000;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(' ');
            sb.append(list.get(i));
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private String changeToString(int i) {
        StringBuilder sb = new StringBuilder();
        if (i / 100 != 0) {
            sb.append(nums[i / 100]);
            sb.append(" Hundred");
        }
        i %= 100;
        if (i == 0) {
            return sb.toString();
        }
        if (1 <= i && i <= 19) {
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(nums[i]);
            return sb.toString();
        }
        if (!sb.isEmpty()) {
            sb.append(' ');
        }
        sb.append(tens[i / 10]);
        i %= 10;
        if (i == 0) {
            return sb.toString();
        }
        sb.append(' ');
        sb.append(nums[i]);
        return sb.toString();
    }
}
