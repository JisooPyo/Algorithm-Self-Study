package leetcode.al2404;

public class Leet2108 {
    public static void main(String[] args) {
        Leet2108 l = new Leet2108();

        String[] words1 = {"abc", "car", "ada", "racecar", "cool"};
        String[] words2 = {"notapalindrome", "racecar"};
        String[] words3 = {"def", "ghi"};

        System.out.println(l.firstPalindrome(words1));  // "ada"
        System.out.println(l.firstPalindrome(words2));  // "racecar"
        System.out.println(l.firstPalindrome(words3));  // ""
    }

    // 내 풀이
    // 첫 번째 풀이는 StringBuilder의 reverse() 메서드를 이용하여 팰린드롬 문자열인지 확인하였다.
    // 두 번째 풀이는 charAt()을 이용하여 직접 비교해서 확인하였다.
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        if (word.length() == 1) {
            return true;
        }
        int index = (word.length() - 2) / 2;
        int sum = word.length() - 1;
        for (int i = 0; i <= index; i++) {
            if (word.charAt(i) != word.charAt(sum - i)) {
                return false;
            }
        }

        return true;
    }
}
