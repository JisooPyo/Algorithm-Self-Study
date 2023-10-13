package programmers.test2310;

import java.util.Arrays;

public class MatrixMultiplication {
	public static void main(String[] args) {
		MatrixMultiplication mm = new MatrixMultiplication();
		int[][] arr1_1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr1_2 = {{3, 3}, {3, 3}};
		// [[15, 15], [15, 15], [15, 15]]

		int[][] arr2_1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr2_2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		// [[22, 22, 11], [36, 28, 18], [29, 20, 14]]

		System.out.println(Arrays.deepToString(mm.solution(arr1_1, arr1_2)));
		System.out.println(Arrays.deepToString(mm.solution(arr2_1, arr2_2)));
	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int x = 0; x < arr1.length; x++) {
			for (int y = 0; y < arr2[0].length; y++) {
				int num = 0;
				for (int i = 0; i < arr1[0].length; i++) {
					num += arr1[x][i] * arr2[i][y];
				}
				answer[x][y] = num;
			}
		}

		return answer;
	}
}

/*
테스트 1 〉통과 (0.69ms, 78.8MB)
테스트 2 〉통과 (6.02ms, 77.4MB)
테스트 3 〉통과 (6.69ms, 89.6MB)
테스트 4 〉통과 (0.47ms, 79MB)
테스트 5 〉통과 (4.02ms, 83MB)
테스트 6 〉통과 (3.04ms, 81.9MB)
테스트 7 〉통과 (0.39ms, 80.8MB)
테스트 8 〉통과 (0.18ms, 70.6MB)
테스트 9 〉통과 (0.17ms, 73.8MB)
테스트 10 〉통과 (6.80ms, 84.9MB)
테스트 11 〉통과 (1.39ms, 84.4MB)
테스트 12 〉통과 (0.15ms, 74.5MB)
테스트 13 〉통과 (5.57ms, 88.3MB)
테스트 14 〉통과 (9.36ms, 92.9MB)
테스트 15 〉통과 (3.23ms, 84.3MB)
테스트 16 〉통과 (1.43ms, 80.2MB)
 */