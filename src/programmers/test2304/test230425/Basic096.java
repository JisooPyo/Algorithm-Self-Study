package programmers.test2304.test230425;

import java.util.Arrays;

public class Basic096 {

	public static void main(String[] args) {

		Basic096 b = new Basic096();
		
		System.out.println(Arrays.toString(b.solution("banana")));
		System.out.println(Arrays.toString(b.solution("programmers")));

	}

	public String[] solution(String my_string) {
		String[] answer = new String[my_string.length()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = my_string.substring(i);
		}
		Arrays.sort(answer);
		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String myString) {
        return IntStream.range(0, myString.length()).mapToObj(myString::substring).sorted().toArray(String[]::new);
    }
}

*/