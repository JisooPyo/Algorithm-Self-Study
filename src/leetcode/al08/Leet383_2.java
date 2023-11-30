package leetcode.al08;

public class Leet383_2 {
    public static void main(String[] args) {
        Leet383_2 l = new Leet383_2();

        System.out.println(l.canConstruct("a", "b")); // false
        System.out.println(l.canConstruct("aa", "ab")); // false
        System.out.println(l.canConstruct("aa", "aab")); // true
        System.out.println(l.canConstruct("aab", "baa")); // true

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            mag[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            mag[index]--;
            if (mag[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
