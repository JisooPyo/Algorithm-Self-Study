package leetcode.al2402;

import java.util.ArrayList;
import java.util.List;

public class Leet9 {
    public static void main(String[] args) {
        Leet9 l = new Leet9();
        System.out.println(l.isPalindrome(121));    // t
        System.out.println(l.isPalindrome(-121));   // f
        System.out.println(l.isPalindrome(10));     // f
    }

    // "palindrome 수는 앞으로 뒤로 읽어도 똑같으므로 뒤에서부터 숫자를 복사해나가도 같을 것"이라는 포인트
    public boolean isPalindromeOther(int x) {
        int copy = x;
        int rev = 0, d = 0;
        if (x < 0) {
            return false;
        }
        while (x > 0) {
            d = x % 10;
            rev = (rev * 10) + d;
            x = x / 10;
        }
        if (copy == rev) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
