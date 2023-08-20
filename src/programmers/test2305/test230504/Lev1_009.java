// 자연수 뒤집어 배열로 만들기

package programmers.test2305.test230504;

import java.util.Arrays;

public class Lev1_009 {

	public static void main(String[] args) {

		Lev1_009 lev = new Lev1_009();

		System.out.println(Arrays.toString(lev.solution(12345)));

	}

	public long[] solution(long n) {
		String n_str = Long.toString(n);
		long[] answer = new long[n_str.length()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = n % 10;
			n = n / 10;
		}
		return answer;
	}

	// n은 10,000,000,000 이하인 자연수
	// long의 최대값 : 9,223,372,036,854,775,807

}

/*

다른 사람의 풀이

import java.util.stream.IntStream;

class Solution {
    public int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}

*/