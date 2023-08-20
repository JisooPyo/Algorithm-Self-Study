// 행렬의 덧셈

package programmers.test2305.test230506;

import java.util.Arrays;

public class Lev1_028 {

	public static void main(String[] args) {
		Lev1_028 lev = new Lev1_028();

		int[][] t1_1 = { { 1, 2 }, { 2, 3 } };
		int[][] t1_2 = { { 3, 4 }, { 5, 6 } };

		int[][] t2_1 = { { 1 }, { 2 } };
		int[][] t2_2 = { { 3 }, { 4 } };

		System.out.println(Arrays.deepToString(lev.solution(t1_1, t1_2)));
		System.out.println(Arrays.deepToString(lev.solution(t2_1, t2_2)));

	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이
어차피 배열크기는 똑같으므로 answer에 arr1을 대입해서 arr2의 원소들을 더해가는 식으로..!

public int[][] solution(int[][] arr1, int[][] arr2) {
	int[][] answer = {};
	answer = arr1;
	for(int i=0; i<arr1.length; i++){
    	for(int j=0; j<arr1[0].length; j++){
        	answer[i][j] += arr2[i][j];
    	}
	}
	return answer;
}

*/