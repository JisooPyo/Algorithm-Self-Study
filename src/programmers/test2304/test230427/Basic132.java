package programmers.test2304.test230427;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Basic132 {

	public static void main(String[] args) {
		Basic132 b = new Basic132();

		boolean t = true;
		boolean f = false;

		int[] x1 = { 3, 7, 2, 5, 4, 6, 1 };
		boolean[] x2 = { f, t, t, t, t, f, f };

		int[] y1 = { 1, 2, 3 };
		boolean[] y2 = { t, t, t };

		int[] z1 = { 6, 1, 5, 2, 3, 4 };
		boolean[] z2 = { t, f, t, f, f, t };

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));
		System.out.println(b.solution(z1, z2));

	}

	public int solution(int[] rank, boolean[] attendance) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < rank.length; i++) {
			if (attendance[i]) {
				list.add(rank[i]); 
			}
		}
		
		String first = Integer.toString(Collections.min(list)); // 2
		list.remove(Integer.valueOf(first));
		String second = Integer.toString(Collections.min(list)); // 4
		list.remove(Integer.valueOf(second));
		String third = Integer.toString(Collections.min(list)); // 5

		String[] rank2 = new String[rank.length];

		for (int i = 0; i < rank2.length; i++) {
			rank2[i] = Integer.toString(rank[i]);
		}

		int firstIndex = Arrays.asList(rank2).indexOf(first);
		int secondIndex = Arrays.asList(rank2).indexOf(second);
		int thirdIndex = Arrays.asList(rank2).indexOf(third);

		int answer = 10000 * firstIndex + 100 * secondIndex + thirdIndex;

		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        return IntStream.range(0, rank.length)
        				// rank 길이만큼 스트림 생성
                .filter(i -> attendance[i])
                	// attendance로 필터링
                .boxed()
                	// Stream로 변환
                .sorted(Comparator.comparing(i -> rank[i]))
                	// 정렬 기준을 rank로 정렬
                .limit(3L)
                	// 낮은 숫자 3개 선정
                .reduce((current, next) -> current * 100 + next)
                	// 100을 곱하고 다음 항목을 더하면서 차원 감소
                .get();
                	// int로 get
    }
}

*/