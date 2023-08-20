package programmers.test2304.test230428;

import java.util.Arrays;

public class Lev0_02 {

	public static void main(String[] args) {
		Lev0_02 l = new Lev0_02();

		String x = "abc1Addfggg4556b"; // x.length : 16
		String y = "abcdef123"; // y.length : 9

		System.out.println(Arrays.toString(l.solution(x, 6)));
		System.out.println(Arrays.toString(l.solution(y, 3)));

	}

	public String[] solution(String my_str, int n) {
		String[] answer = new String[(my_str.length() - 1) / n + 1]; 
		for (int i = 0; i < answer.length; i++) {
			System.out.println(my_str);
			if (my_str.length() < n) {
				answer[answer.length - 1] = my_str;
			} else {
				answer[i] = my_str.substring(0, n);
				my_str = my_str.substring(n);
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String myStr, int n) {
        return IntStream
        		.range(0, myStr.length() / n + (myStr.length() % n > 0 ? 1 : 0))
        		// 0에서 answer 길이-1만큼의 IntStream 선언

                .mapToObj(i -> i == myStr.length() / n ? myStr.substring(i * n) : myStr.substring(i * n, (i + 1) * n))
                // IntStream의 i가 myStr 길이를 n으로 나눈값과 같으면 substring(i*n)
                 *									  다르면 substring(i*n,(i+1)*n) 리턴.
                 * 원시타입 IntSteam을 일반적인 Stream인 Stream<String>으로 변환하므로 mapToObj 메소드 사용 
                
                .toArray(String[]::new);
                // Stream<String>을 String 배열로 변환하여 리턴.
    }
}

*/