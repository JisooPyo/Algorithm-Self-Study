package programmers.test2309;

import java.util.Arrays;

public class Carpet {
	public static void main(String[] args) {
		Carpet carpet = new Carpet();
		System.out.println(Arrays.toString(carpet.solution(10, 2)));
		System.out.println(Arrays.toString(carpet.solution(8, 1)));
		System.out.println(Arrays.toString(carpet.solution(24, 24)));
	}

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		// yellow의 약수를 구한다. yellow = x * y; ex. 2 = 1 * 2;
		// 2x+2y+4= brown인지 확인한다.
		// 조건에 맞는 y+1, x+1을 배열에 넣어 return한다.
		for (int i = 1; i <= Math.sqrt(yellow); i++) {
			if (yellow % i == 0) {
				if ((yellow / i) * 2 + i * 2 + 4 == brown) {
					answer[1] = i + 2;
					answer[0] = yellow / i + 2;
					break;
				}
			}
		}
		return answer;
	}
}
