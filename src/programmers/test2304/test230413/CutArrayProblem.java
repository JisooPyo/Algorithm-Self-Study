package programmers.test2304.test230413;

import java.util.Arrays;

public class CutArrayProblem {

	public static void main(String[] args) {

		CutArrayProblem c = new CutArrayProblem();

		int[] x1 = { 1, 2, 3, 4, 5 };
		int x2 = 1;
		int x3 = 3;
		int[] y1 = { 1, 3, 5 };
		int y2 = 1;
		int y3 = 2;

		System.out.println(Arrays.toString(c.solution(x1, x2, x3)));
		System.out.println(Arrays.toString(c.solution(y1, y2, y3)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(x1, x2, x3+1)));
		

	}

	public int[] solution(int[] numbers, int num1, int num2) {
		int[] answer = new int[num2 - num1 + 1];

		for (int i = 0; i <= (num2 - num1); i++) {

			answer[i] = numbers[i + num1];

		}

		return answer;
	}

}

/*
 * 
 * 다른 사람의 풀이
 * 
 * public int[] solution(int[] numbers, int num1, int num2) {
 * 
 * 		return Arrays.copyOfRange(numbers, num1, num2 + 1);
 * 
 * }
 * 
 * Arrays.copyOfRange(numbers,num1,num2+1)
 * 		-> 배열 numbers 복사하는데, num1부터 num2까지 복사해주세요.  
 * 
 */