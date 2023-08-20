package programmers.test2304.test230428;

public class Lev0_01 {

	public static void main(String[] args) {
		Lev0_01 l = new Lev0_01();

		int[] x = { 7, 77, 17 };
		int[] y = { 10, 29 };

		System.out.println(l.solution(x));
		System.out.println(l.solution(y));

	}

	public int solution(int[] array) {
		int answer = 0;
		String[] ansToStr = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			ansToStr[i] = Integer.toString(array[i]);
		}
		for (int i = 0; i < ansToStr.length; i++) {
			for (int j = 0; j < ansToStr[i].length(); j++) {
				if (ansToStr[i].charAt(j) == '7') {
					answer++;
				}
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
        return (int) Arrays.stream(
                        Arrays.stream(array)
                        			// array를 stream으로 변환
                                .mapToObj(String::valueOf)
                                	// 스트림에서는 일반적인 stream객체를 원시 타입 stream으로 변환할 수 있는데
                                	 * mapToObj는 그 반대라고 생각하면 된다.
                                	 * 아래 코드 참고
                                	 * 여기서는 array가 int타입이므로
                                	 * 원시타입 IntSteam을 일반적인 Stream인 Stream<String>으로 변환.
                                .collect(Collectors.joining())
                                	// collector 메소드 .joining() 생성자
                                	 * 스트림의 각 요소를 합쳐 String으로 리턴.
                                .split("")
                                	// String을 한 자씩 구분한 array 리턴.
                )
                	// String을 한 자씩 구분한 array를 stream으로 변환
                .filter(s -> s.equals("7"))
                	// stream 원소 중 "7"과 같은 원소만 구분.
                .count();
                	// stream 원소 개수 count
    }
}

--------------------------------------------------------------------------------------------
mapToObj()
 * 일반적인 Stream 객체 : ex. Stream<String>
 * 원시 Stream : ex. IntStream.range(1,4)

Stream.of(1.0, 2.0)
			// Stream<Double>이라는 객체를 of()메소드를 통해서 생성.
	.mapToInt(Double::intValue)
			// 객체를 int타입으로 변경. 일반적인 Stream객체를 원시타입 IntStream으로 변경.
    .mapToObj(String:valueOf)
    		// 원시타입 IntStream에서 Stream<String>으로 변환.
    .collect(Collectors.toList());

*/
