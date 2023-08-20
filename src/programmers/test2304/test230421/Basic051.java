package programmers.test2304.test230421;

public class Basic051 {

	public static void main(String[] args) {

		Basic051 b = new Basic051();

		int[] x = { 4, 2, 6, 1, 7, 6 };
		int[] y = { -1, 2, 5, 6, 3 };

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public int solution(int[] num_list) {
		int even = 0;
		int odd = 0;
		for (int i = 0; i < num_list.length; i++) {
			if (i % 2 == 0) {
				odd += num_list[i];
			} else {
				even += num_list[i];
			}
		}
		
		return Math.max(even, odd);
	}

}
