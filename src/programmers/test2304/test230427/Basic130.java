package programmers.test2304.test230427;

import java.util.Arrays;

public class Basic130 {

	public static void main(String[] args) {
		Basic130 b = new Basic130();

		String[] x = { ".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...." };
		String[] y = { "x.x", ".x.", "x.x" };

		System.out.println(Arrays.toString(b.solution(x, 2)));
		System.out.println(Arrays.toString(b.solution(y, 3)));

	}

	public String[] solution(String[] picture, int k) {
		String[] answer = new String[picture.length * k];
		for (int i = 0; i < picture.length; i++) {
			String str = "";
			for (int j = 0; j < picture[i].length(); j++) {
				if (picture[i].charAt(j) == '.') {
					for (int l = 1; l <= k; l++) {
						str += ".";
					}
				} else {
					for (int l = 1; l <= k; l++) {
						str += "x";
					}
				}
			}
			for (int ind = i * k; ind < (i + 1) * k; ind++) {
				answer[ind] = str;
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

repeat..!!가 있었지 참..

for(int l=0; l<picture[i].length(); l++) {
                    sb.append(String.valueOf(picture[i].charAt(l)).repeat(k));
                }

*/