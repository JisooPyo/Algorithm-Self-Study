// 크기가 작은 부분문자열

package programmers.test2305.test230508;

import java.math.BigInteger;

public class Lev1_039 {

	public static void main(String[] args) {
		Lev1_039 lev = new Lev1_039();

		String t1_1 = "3141592";
		String t1_2 = "271";

		String t2_1 = "500220839878";
		String t2_2 = "7";

		String t3_1 = "10203";
		String t3_2 = "15";

		System.out.println(lev.solution(t1_1, t1_2));
		System.out.println(lev.solution(t2_1, t2_2));
		System.out.println(lev.solution(t3_1, t3_2));

	}

	public int solution(String t, String p) {
		int answer = 0;
		for (int i = 0; i <= t.length() - p.length(); i++) {
			String str = t.substring(i, i + p.length());
			BigInteger big_p = new BigInteger(p);
			BigInteger big_str = new BigInteger(str);
			if (big_p.compareTo(big_str) != -1) {
				answer++;
			}
		}
		return answer;
	}

}

// 1, 5, 7, 9, 12, 13, 17, 22, 23, 24, 25, 26, 28, 36 런타임에러

// Integer.parseInt(p)와 Integer.parseInt(str)을 비교하는게 아니라
// Integer.valueOf(p)와 Integer.valueOf(str)로 래퍼 클래스로 바꿔 비교!

// 1, 5, 7, 9, 12, 13, 17, 22, 23, 24, 25, 26, 28, 36 똑같이 에러..? 

// BigInteger로 바꿨더니 해결!