package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic119 {

	public static void main(String[] args) {
		Basic119 b = new Basic119();

		int[] x = { 2, 1, 6 };
		int[] y = { 5, 2, 1, 7, 5 };

		System.out.println(Arrays.toString(b.solution(x, 1)));
		System.out.println(Arrays.toString(b.solution(y, 3)));

	}

	public int[] solution(int[] num_list, int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = n; i < num_list.length; i++) {
			list.add(num_list[i]);
		}
		for (int i = 0; i < n; i++) {
			list.add(num_list[i]);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

}


/*

다른 사람의 풀이

import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream
        	.range(0, num_list.length)
        	.map(i -> num_list[(i + n) % num_list.length])
        	.toArray();
    }
}

0 -> num_list[(0+3)%5=3]
1 -> num_list[(1+3)%5=4]
2 -> num_list[(2+3)%5=0]
3 -> num_list[(3+3)%5=1]
4 -> num_list[(4+3)%5=2]

*/