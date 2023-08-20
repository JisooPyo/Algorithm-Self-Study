package programmers.test2304.test230425;

import java.util.Arrays;

public class Basic106 {

	public static void main(String[] args) {
		Basic106 b = new Basic106();

		System.out.println(Arrays.deepToString(b.solution(3)));
		System.out.println(Arrays.deepToString(b.solution(6)));
		System.out.println(Arrays.deepToString(b.solution(1)));

	}

	public int[][] solution(int n) {
		int[][] answer = new int[n][n];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				if(i==j) {
					answer[i][j]=1;
				} else {
					answer[i][j]=0;
				}
			}
		}
		return answer;
	}

}
/*

다른 사람의 풀이

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            answer[i][i] = 1;
        }
        return answer;
    }

*/