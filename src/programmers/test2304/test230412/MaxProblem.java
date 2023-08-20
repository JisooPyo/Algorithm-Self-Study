package programmers.test2304.test230412;

import java.util.Arrays;

public class MaxProblem {

	public static void main(String[] args) {
		
		MaxProblem mp = new MaxProblem();
		
		int[] a = {1,2,3,4,5};
		int[] b = {0,31,24,10,1,9};
		
		System.out.println(mp.solution(a));
		System.out.println(mp.solution(b));

	}
	
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        answer = numbers[numbers.length-1]*numbers[numbers.length-2];
        return answer;
    }

}
