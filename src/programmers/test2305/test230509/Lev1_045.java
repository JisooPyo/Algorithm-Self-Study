// 푸드 파이트 대회

package programmers.test2305.test230509;

public class Lev1_045 {

	public static void main(String[] args) {

		Lev1_045 lev = new Lev1_045();

		int[] t1 = { 1, 3, 4, 6 };
		int[] t2 = { 1, 7, 1, 2 };

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));

	}

	public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < food.length; i++) {
			sb.append(String.valueOf(i).repeat(food[i] / 2));
		}
		return sb.toString() + "0" + sb.reverse().toString();
	}

}

/*
 * 
 * 다른 사람의 풀이
 * 
 * 0을 미리 만들어놓고 중간부터 붙이기!
 * 
 * public String solution(int[] food) {
 * 		String answer = "0";
 * 		for (int i = food.length - 1; i > 0; i--) {
 * 			for (int j = 0; j < food[i] / 2; j++) {
 * 				answer = i + answer + i;
 * 			}
 * 		}
 * 		return answer;
 * }
 * 
 */
