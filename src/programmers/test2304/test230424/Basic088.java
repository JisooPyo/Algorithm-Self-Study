package programmers.test2304.test230424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic088 {

	public static void main(String[] args) {
		Basic088 b = new Basic088();

		System.out.println(Arrays.toString(b.solution(10)));

	}

	public int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(n);
		while (n > 1) {
			if (n % 2 == 0) {
				list.add(n / 2);
				n = n / 2;
			} else {
				list.add(n * 3 + 1);
				n = n * 3 + 1;
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

우왕.. 모르겟더.. 

import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        return IntStream.concat(
                        IntStream.iterate(n, i -> i > 1, i -> i % 2 == 0 ? i / 2 : i * 3 + 1),
                        IntStream.of(1))
                .toArray();
    }
}


*/