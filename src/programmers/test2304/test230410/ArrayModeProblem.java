package programmers.test2304.test230410;

public class ArrayModeProblem {

	public int solution(int[] array) {
		int answer = 0;

		// 1. array의 최대값 구하기
		int arrayMax = 0; // array의 최대값
		for (int i = 0; i < array.length; i++) {
			if (array[i] > arrayMax) {
				arrayMax = array[i];
			}
		}

		// 2. array 안의 값으로 인덱스를 만들어 배열 만들고 카운트하기
		int[] arrayCount = new int[arrayMax + 1];
		for (int i = 0; i < array.length; i++) {

			arrayCount[array[i]]++;
		}

		// 3. 카운트수의 최대값 구하기
		int arrayCountMax = 0;
		for (int i = 0; i < arrayCount.length; i++) {
			if (arrayCount[i] > arrayCountMax) {
				arrayCountMax = arrayCount[i];
			}
		}

		// 4. arrayCount[]값과 arrayCountMax값을 비교하여 최빈값의 개수 구하기
		int numberOfMode = 0; // 최빈값의 개수
		for (int i = 0; i < arrayCount.length; i++) {
			if (arrayCount[i] == arrayCountMax) {
				numberOfMode++;
				answer = i;
			}
			if (numberOfMode > 1) {
				answer = -1; // 최빈값의 개수가 2개 이상이면 답은 -1
			}
		}

		return answer;
	}
}
