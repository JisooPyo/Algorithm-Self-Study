package programmers.test2304.test230412;

public class TheNumberOfNumbersProblem {

	public static void main(String[] args) {

		TheNumberOfNumbersProblem nn = new TheNumberOfNumbersProblem();

		int[] a = { 1, 1, 2, 3, 4, 5 };
		int[] b = { 0, 2, 3, 4 };

		System.out.println(nn.solution(a, 1));
		System.out.println(nn.solution(b, 1));

	}

	public int solution(int[] array, int n) {
		int answer = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				answer++;
			}
		}
		return answer;
	}
}
