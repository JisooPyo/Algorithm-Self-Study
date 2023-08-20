// k번째 수

package programmers.test2305.test230508;

import java.util.Arrays;

public class Lev1_042 {

	public static void main(String[] args) {
		Lev1_042 lev = new Lev1_042();

		int[] t1 = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] t1_2 = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.println(Arrays.toString(lev.solution(t1, t1_2)));

	}

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] temp = new int[commands[i][1] - commands[i][0] + 1];
			for (int j = 0; j < temp.length; j++) {
				temp[j] = array[commands[i][0] + j - 1];
			}
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2] - 1];
		}
		return answer;
	}

}

/*

다른 사람의 풀이

Arrays.copyOfRange 메소드를 이용하면 되는거였다...!

*/