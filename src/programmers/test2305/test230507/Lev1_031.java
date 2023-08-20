package programmers.test2305.test230507;

public class Lev1_031 {

	public static void main(String[] args) {
		Lev1_031 lev = new Lev1_031();

		System.out.println(lev.solution("AB", 3));
		// 기대값 "DE"
		System.out.println(lev.solution("z", 3));
		// 기대값 "c"
		System.out.println(lev.solution("a B z", 3));
		// 기대값 "d E c"

	}

	public String solution(String s, int n) {
		// 'A'=65, 'Z'=90, 'a'=97, 'z'=122, ' '=32
		char[] s_char = s.toCharArray();
		for (int i = 0; i < s_char.length; i++) {
			char ch = s_char[i];
			if (ch == 32) {
				continue;
			}
			int num = ch + n;
			if ((65 <= ch && ch <= 90 && 90 < ch + n) || (97 <= ch && ch <= 122 && 122 < ch + n)) {
				num = num - 26;
			}
			s_char[i] = (char) num;
		}
		return new String(s_char);
	}

}

// 다른 사람의 풀이
// 65 <= ch && ch <= 90 대신에 Character.isLowerCase(ch)를 이용!