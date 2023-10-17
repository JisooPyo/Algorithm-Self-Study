package programmers.test2310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DevelopFeature {
	public static void main(String[] args) {
		DevelopFeature df = new DevelopFeature();

		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		// [2, 1]

		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		// [1, 3, 2]

		System.out.println(Arrays.toString(df.solution(progresses1, speeds1)));
		System.out.println(Arrays.toString(df.solution(progresses2, speeds2)));
	}

	public int[] solution(int[] progresses, int[] speeds) {
		int day = (100 - progresses[0]) / speeds[0];
		if ((100 - progresses[0]) % speeds[0] != 0) {
			day++;
		}
		int count = 1;

		List<Integer> answerList = new ArrayList<>();
		for (int i = 1; i < progresses.length; i++) {
			int end = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0) {
				end++;
			}
			if (day < end) {
				day = end;
				answerList.add(count);
				count = 1;
			} else {
				count++;
			}
		}
		answerList.add(count);

		// answerList -> array
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}
}

// 문제가 스택/큐 문제인데 스택/큐로 풀지 않았다.
// 나는 day라는 변수를 두고 비교했지만
// 큐에 배포 날짜를 넣어서 peek로 비교하는 로직으로 풀고 나중에 array로 옮길 때는
// poll()을 써서 array를 만들어주면 될 것 같음.

/*
테스트 1 〉통과 (0.04ms, 72.9MB)
테스트 2 〉통과 (0.04ms, 78.9MB)
테스트 3 〉통과 (0.04ms, 73.4MB)
테스트 4 〉통과 (0.04ms, 71.5MB)
테스트 5 〉통과 (0.04ms, 76.6MB)
테스트 6 〉통과 (0.03ms, 72.8MB)
테스트 7 〉통과 (0.05ms, 71.9MB)
테스트 8 〉통과 (0.07ms, 84.7MB)
테스트 9 〉통과 (0.03ms, 77.8MB)
테스트 10 〉통과 (0.08ms, 76.6MB)
테스트 11 〉통과 (0.03ms, 72.3MB)
 */
