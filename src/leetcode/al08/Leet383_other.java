package leetcode.al08;

public class Leet383_other {
    public static void main(String[] args) {
        Leet383_other l = new Leet383_other();

//		System.out.println(l.canConstruct("a", "b")); // false
//		System.out.println(l.canConstruct("aa", "ab")); // false
//		System.out.println(l.canConstruct("aa", "aab")); // true
        System.out.println(l.canConstruct("aab", "baa")); // true

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 길면 안되는거니까 미리 경우 빼준다.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 가장 마지막에 있는 인덱스를 찾아서 갱신해주는 로직.
        int[] letters = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int index = magazine.indexOf(ch, letters[ch - 'a']);
            if (index == -1) {
                return false;
            }
            letters[ch - 'a'] = index + 1;
        }
        return true;
    }
}
