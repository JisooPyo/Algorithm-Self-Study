package programmers.test2304.test230425;

import java.util.Arrays;

public class Basic094 {

	public static void main(String[] args) {
		Basic094 b = new Basic094();

		int[] x = { 2, 1, 6 };
		int[] y = { 5, 2, 1, 7, 5 };
		
		System.out.println(Arrays.toString(b.solution(x, 3)));
		System.out.println(Arrays.toString(b.solution(y, 2)));


	}

	public int[] solution(int[] num_list, int n) {
		int[] answer = new int[num_list.length-n+1];
		for(int i=0;i<answer.length;i++) {
			answer[i]=num_list[n-1+i];
		}
		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] a= Arrays.copyOfRange(num_list, n-1, num_list.length);
        return a;
    }
}


*/