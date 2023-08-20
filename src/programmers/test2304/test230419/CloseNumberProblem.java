package programmers.test2304.test230419;

import java.util.ArrayList;
import java.util.List;

public class CloseNumberProblem {

	public static void main(String[] args) {
		
		CloseNumberProblem cn = new CloseNumberProblem();

		int[] x1 = { 3, 10, 28 };
		int x2 = 20;

		int[] y1 = { 10, 11, 12 };
		int y2 = 13;
		
		System.out.println(cn.solution(x1, x2));
		System.out.println(cn.solution(y1, y2));

	}

	public int solution(int[] array, int n) {

		int[] minus = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			minus[i] = n - array[i];

			if (minus[i] < 0) {
				minus[i] = minus[i] * (-1);
			}
		} // minus = [17, 10, 8, 8]

		int compare = minus[0];

		for (int i = 1; i < minus.length; i++) {
			if (compare > minus[i]) {
				compare = minus[i];
			}
		} // compare = 8

		int count = 0;
		List<Integer> index = new ArrayList<>();

		for (int i = 0; i < minus.length; i++) {
			if (minus[i] == compare) {
				count++;
				index.add(i);
			}
		} // count = 2 , index = {2,3}

		// list int[]로 변환
		int[] indexInt = index.stream().mapToInt(i -> i).toArray();

		int answer = 0;

		if (count == 2) {

			if (array[indexInt[0]] > array[indexInt[1]]) {

				answer = array[indexInt[1]];

			} else {
				answer = array[indexInt[0]];
			}

		} else {
			answer = array[indexInt[0]];
		}

		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        for(int i = 1 ; i < array.length ; i++){
            if(Math.abs(n-array[0]) > Math.abs(n-array[i])){
                array[0] = array[i];
            }
        }
        answer = array[0];
        return answer;
    }
}

*/
