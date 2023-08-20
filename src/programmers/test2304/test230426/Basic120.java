package programmers.test2304.test230426;

public class Basic120 {

	public static void main(String[] args) {
		Basic120 b = new Basic120();

		int[] x = { 12, 4, 15, 1, 14 };

		System.out.println(b.solution(x));

	}

	public int solution(int[] num_list) {
		int count = 0;

		for (int i = 0; i < num_list.length; i++) {
			int div = num_list[i];
			while (div > 1) {
				if (div % 2 == 0) {
					div = div / 2;
					count++;
				} else {
					div = (div - 1) / 2;
					count++;
				}
			}
		}
		return count;
	}

}

/*

다른 사람의 풀이

이 방법은 죽었다 깨어나도 생각 못했겠다...

import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        return Arrays
        		.stream(num_list)
        		.map(i -> Integer
        			.toBinaryString(i)
        			.length() - 1)
        		.sum();
    }
}

*/
