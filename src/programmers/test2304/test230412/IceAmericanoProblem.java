package programmers.test2304.test230412;

import java.util.Arrays;

public class IceAmericanoProblem {

	public static void main(String[] args) {
		
		IceAmericanoProblem aa = new IceAmericanoProblem();
		
		int[] a = aa.solution(5500);
		int[] b = aa.solution(15000);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		

	}

	public int[] solution(int money) {
		int[] answer = new int[2];
		
		answer[0] = money / 5500;
		answer[1] = money % 5500;
		
		return answer;
	}

}

/*

다른 사람의 풀이

class Solution {
    public int[] solution(int money) {
        return new int[] { money / 5500, money % 5500 };
    }
}

*/