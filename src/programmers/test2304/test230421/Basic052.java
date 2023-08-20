package programmers.test2304.test230421;

public class Basic052 {

	public static void main(String[] args) {

		Basic052 b = new Basic052();

		int[] x = { 3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1 };
		int[] y = { 2, 3, 4, 5 };

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public int solution(int[] num_list) {
		int sum = 0;
		int multiple = 1;
		for (int i = 0; i < num_list.length; i++) {
			sum += num_list[i];
			multiple *= num_list[i];
		}
		if (num_list.length >= 11) {
			return sum;
		} else {
			return multiple;
		}
	}

}

//public int solution(int[] num_list) {
//	IntStream stream = IntStream.of(num_list);
//	return num_list.length > 10 ? stream.sum() : stream.reduce(1, (a, b) -> a * b);
//}

// https://cornswrold.tistory.com/544
// reduce는 두 개의 인수를 갖는다.
// * 초깃값
// * 스트림의 두 요소를 합쳐서 하나의 값으로 만드는 데 사용할 람다.
// { 4, 5, 6, 9 }에서 stream.reduce(0, (a, b) -> a + b)를 쓰면
// 람다의 첫번째 파라미터 (a)에 0이 사용. 스트림에서 4를 소비해서 두 번째 파라미터(b)로 사용
// 0+4의 결과인 4가 새로운 누적값(accumulated value)이 됨. 누적값으로 람다를 다시 호출하여 반복.
// a에 다시 4, 스트림에서 5를 소비하여 다시 b 사용. -> 4 + 5 = 9 -> a = 9
// a = 9, b = 6 -> 9 + 6 = 15 -> a = 15
// a = 15, b = 9 -> 15 + 9 = 24 -> 끝.

// 위에서 stream.reduce(1, (a, b) -> a * b)을 쓰면 스트림의 모든 원소의 곱을 구할 수 있다.

// reduce에서 최대, 최소 구하기
// stream.reduce(Integer::max)
// 4 -> 5 -> 5가 더 큼 -> 5 -> 3 -> 5가 더 큼 -> 5 -> 9 -> 9가 더 큼 -> 9 출력





