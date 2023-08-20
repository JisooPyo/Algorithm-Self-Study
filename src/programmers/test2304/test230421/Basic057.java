package programmers.test2304.test230421;

public class Basic057 {

	public static void main(String[] args) {
		Basic057 b = new Basic057();

		int[] x = { 34, 5, 71, 29, 100, 34 };
		int[] y = { 58, 44, 27, 10, 100 };

		System.out.println(b.solution(x, 123));
		System.out.println(b.solution(y, 139));

	}

	public int solution(int[] numbers, int n) {

		int answer = 0;
		for (int i = 0; i < numbers.length; i++) {
			if(answer>n) {
				return answer;
			} else {
				answer+=numbers[i];
			}
		}
		return answer;
	}

}
