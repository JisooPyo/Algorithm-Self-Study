package programmers.test2304.test230426;

import java.util.Arrays;

public class Basic107 {

	public static void main(String[] args) {
		Basic107 b = new Basic107();

		String x = "programmers";

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(65 == 'A');
//		for (int i = 0; i < b.solution(x).length; i++) {
//			if (b.solution(x)[i] >= 1) {
//				if (0 <= i && i <= 25) {
//					System.out.println((char) (i + 65) + " : " + b.solution(x)[i]);
//				} else {
//					System.out.println((char) (i + 71) + " : " + b.solution(x)[i]);
//				}
//			}
//
//		}

	}

	public int[] solution(String my_string) {
		int[] answer = new int[52];
		char[] ch = my_string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			for (int j = 65; j <= 90; j++) {
				if (ch[i] == j) {
					answer[j - 65]++;
				}
			}
			for (int k = 97; k <= 122; k++) {
				if (ch[i] == k) {
					answer[k - 71]++;
				}
			}
		}

		return answer;
	}

}

/*

다른 사람의 풀이

 for(char ch: my_string.toCharArray()) {
            answer[ch - 'A' - (Character.isLowerCase(ch)?6:0)]++;
        }

*/