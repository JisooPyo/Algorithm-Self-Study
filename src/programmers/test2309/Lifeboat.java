package programmers.test2309;

import java.util.Arrays;

public class Lifeboat {
	public static void main(String[] args) {
		Lifeboat lifeboat = new Lifeboat();
		int[] people1 = {70, 50, 80, 50};
		int[] people2 = {70, 80, 50};

		System.out.println(lifeboat.solution(people1, 100));
		System.out.println(lifeboat.solution(people2, 100));
	}

	// 무인도에 갇힌 사람은 1명 이상 50,000명 이하
	// 구명 보트는 최대 2명
	public int solution(int[] people, int limit) {
		if (people.length == 1) {
			return 1;
		}
		Arrays.sort(people);
		int minIndex = 0;
		int count = 0;
		for (int i = people.length - 1; i >= minIndex; i--) {
			if (i == minIndex) {
				count++;
				break;
			}
			if (people[minIndex] + people[i] > limit) {
				count++;
			} else {
				minIndex++;
				count++;
			}
		}
		return count;
	}
}

// return count+1 : 2, 8, 14, 15 통과
// https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
// 참고하여 풀이함.