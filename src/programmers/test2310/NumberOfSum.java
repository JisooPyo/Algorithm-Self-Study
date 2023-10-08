package programmers.test2310;

import java.util.HashSet;
import java.util.Set;

public class NumberOfSum {
	public static void main(String[] args) {
		NumberOfSum nos = new NumberOfSum();

		int[] elements1 = {7, 9, 1, 1, 4};
		System.out.println(nos.solution(elements1));
	}

	public int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();
		int length = 1;
		while (length <= elements.length) {
			for (int i = 0; i < elements.length; i++) {
				int sum = 0;
				int index = i;
				for (int j = 1; j <= length; j++) {
					if (index >= elements.length) {
						index = index % elements.length;
					}
					sum += elements[index++];
				}
				set.add(sum);
			}
			length++;
		}
		return set.size();
	}
}

/*
테스트 1 〉통과 (0.17ms, 84.1MB)
테스트 2 〉통과 (28.66ms, 83.9MB)
테스트 3 〉통과 (50.25ms, 88.8MB)
테스트 4 〉통과 (95.48ms, 102MB)
테스트 5 〉통과 (179.50ms, 83.2MB)
테스트 6 〉통과 (299.46ms, 111MB)
테스트 7 〉통과 (341.10ms, 123MB)
테스트 8 〉통과 (612.68ms, 114MB)
테스트 9 〉통과 (1173.65ms, 129MB)
테스트 10 〉통과 (1207.19ms, 122MB)
테스트 11 〉통과 (230.45ms, 96.4MB)
테스트 12 〉통과 (320.92ms, 102MB)
테스트 13 〉통과 (470.38ms, 98.9MB)
테스트 14 〉통과 (526.88ms, 133MB)
테스트 15 〉통과 (522.64ms, 118MB)
테스트 16 〉통과 (567.11ms, 128MB)
테스트 17 〉통과 (585.89ms, 110MB)
테스트 18 〉통과 (837.36ms, 139MB)
테스트 19 〉통과 (887.30ms, 119MB)
테스트 20 〉통과 (893.83ms, 116MB)
 */