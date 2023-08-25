package leetcode.al08;

public class L383 {
	public static void main(String[] args) {
		L383 l = new L383();

		System.out.println(l.canConstruct("a", "b")); // false
		System.out.println(l.canConstruct("aa", "ab")); // false
		System.out.println(l.canConstruct("aa", "aab")); // true
		System.out.println(l.canConstruct("aab", "baa")); // true

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] ran = new int[26];
		int[] mag = new int[26];
		for (int i = 0; i < ransomNote.length(); i++) {
			ran[ransomNote.charAt(i) - 'a']++;
		}
		for (int i = 0; i < magazine.length(); i++) {
			mag[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (mag[i] < ran[i]) {
				return false;
			}
		}
		return true;
	}
}
