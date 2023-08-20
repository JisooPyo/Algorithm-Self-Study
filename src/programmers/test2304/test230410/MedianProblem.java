package programmers.test2304.test230410;

import java.util.Arrays;

public class MedianProblem {

	public int solution(int[] array) {
		int answer = 0;
		Arrays.sort(array);
		int i = array.length/2;
		answer = array[i];
		return answer;
	}

}

/*

5 2
7 3
9 4
11 5

*/
