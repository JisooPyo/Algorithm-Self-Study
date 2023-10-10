package programmers.test2310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SalesEvent {
	public static void main(String[] args) {
		SalesEvent se = new SalesEvent();

		String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
		int[] number1 = {3, 2, 2, 2, 1};
		String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		// 3

		String[] want2 = {"apple"};
		int[] number2 = {10};
		String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
		// 0

		System.out.println(se.solution(want1, number1, discount1));
		System.out.println(se.solution(want2, number2, discount2));
	}

	public int solution(String[] want, int[] number, String[] discount) {
		// Map에 원하는 제품 저장
		Map<String, Integer> wantMap = new HashMap<>();
		for (int i = 0; i < number.length; i++) {
			wantMap.put(want[i], number[i]);
		}

		// 가능한 날
		int answer = 0;

		// discount 배열을 돌면서 회원가입 해도 되는지 체크
		for (int i = 0; i < discount.length; i++) {
			if (i + 10 > discount.length) {
				break;
			}
			String[] strArr = Arrays.copyOfRange(discount, i, i + 10);
			if (signup(wantMap, strArr)) {
				answer++;
			}
		}

		return answer;
	}

	// 회원가입 해도 되는 지 체크하는 메서드
	public boolean signup(Map<String, Integer> map, String[] strArr) {
		// 맵 복사
		Map<String, Integer> copy = new HashMap<>(Map.copyOf(map));

		// 하나씩 빼기
		for (int i = 0; i < 10; i++) {
			copy.put(strArr[i], copy.getOrDefault(strArr[i], 0) - 1);
		}

		// 하나라도 남아 있으면 false
		for (String key : copy.keySet()) {
			if (copy.get(key) > 0) {
				return false;
			}
		}

		// 남아 있지 않으면 true
		return true;
	}
}

/*
테스트 1 〉통과 (53.31ms, 111MB)
테스트 2 〉통과 (105.10ms, 124MB)
테스트 3 〉통과 (38.34ms, 111MB)
테스트 4 〉통과 (94.06ms, 126MB)
테스트 5 〉통과 (80.75ms, 117MB)
테스트 6 〉통과 (21.74ms, 91.4MB)
테스트 7 〉통과 (49.63ms, 123MB)
테스트 8 〉통과 (116.86ms, 149MB)
테스트 9 〉통과 (60.82ms, 121MB)
테스트 10 〉통과 (88.43ms, 120MB)
테스트 11 〉통과 (42.67ms, 111MB)
테스트 12 〉통과 (0.07ms, 74.5MB)
 */