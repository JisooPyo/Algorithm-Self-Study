package programmers.test2305.test230502;

public class Lev1_007 {

	public static void main(String[] args) {
		Lev1_007 lev = new Lev1_007();

		System.out.println(lev.solution("pPoooyY"));
		System.out.println(lev.solution("Pyy"));

	}

	boolean solution(String s) {
		int low_p = 0;
		int up_p = 0;
		int low_y = 0;
		int up_y = 0;
		char[] ch = s.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'p') {
				low_p++;
			} else if (ch[i] == 'P') {
				up_p++;
			} else if (ch[i] == 'y') {
				low_y++;
			} else if (ch[i] == 'Y') {
				up_y++;
			}
		}

		if (low_p + up_p + low_y + up_y == 0) {
			return true;
		}

		return low_p + up_p == low_y + up_y ? true : false;
	}

}

/*
 * 
 * 다른 사람의 풀이
 * 
 * 다 소문자로 바꿔서 count에 +해주고 -해주면서 count값에 따라 리턴하면 끝..! 멋있다 풀이
 * 
 * class Solution { boolean solution(String s) { s = s.toLowerCase(); int count
 * = 0;
 * 
 * for (int i = 0; i < s.length(); i++) {
 * 
 * if (s.charAt(i) == 'p') count++; else if (s.charAt(i) == 'y') count--; }
 * 
 * if (count == 0) return true; else return false; } }
 * 
 */
