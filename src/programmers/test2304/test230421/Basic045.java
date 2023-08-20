package programmers.test2304.test230421;

import java.util.Arrays;

public class Basic045 {

	public static void main(String[] args) {
		Basic045 b = new Basic045();
		
		System.out.println(Arrays.toString(b.solution(3, 10)));

	}

	public int[] solution(int start, int end) {
		int[] answer = new int[end - start + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = start + i;
		}
		return answer;
	}

}

/*

다른 사람의 풀이

    return IntStream.rangeClosed(start, end).toArray();
 
 ------------------------------------------------------------   
    int[] answer = new int[end-(start-1)];
    for(int i=0; i<answer.length; i++){
        answer[i] = start;
        start++;
    }
    return answer;

*/