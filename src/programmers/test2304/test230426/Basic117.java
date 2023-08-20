package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic117 {

	public static void main(String[] args) {
		Basic117 b = new Basic117();

		String x = "oxooxoxxox";
		String y = "xabcxdefxghi";
		
		System.out.println(Arrays.toString(x.split("x")));
		System.out.println(Arrays.toString(y.split("x")));

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public int[] solution(String myString) {
		List<Integer> list = new ArrayList<>();
		String[] split = myString.split("x");

		for (int i = 0; i < split.length; i++) {
			list.add(split[i].length());
		}
		if (myString.charAt(myString.length() - 1) == 'x')
			list.add(0);

		return list.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

import java.util.stream.Stream;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String myString) {
        IntStream stream = Stream
        			.of(myString.split("x"))
        			.mapToInt(String::length);

        if(myString.endsWith("x")) {
            stream = IntStream.concat(stream, IntStream.of(0));
        }

        return stream.toArray();
    }
}

*/