package programmers.test2304.test230422;

public class Basic065 {

	public static void main(String[] args) {
		Basic065 b = new Basic065();

		int[] x = { 3, 4, 5, 2, 1 };
		int[] y = { 5, 7, 8, 3 };

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

		String a = "";
		a += 2;
		a += 4;
		System.out.println(a); // a = 24

	}

	public int solution(int[] num_list) {
		String odd = "";
		String even = "";
		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] % 2 == 1) {
				odd += num_list[i];
			} else {
				even += num_list[i];
			}
		}

		return Integer.parseInt(even) + Integer.parseInt(odd);

	}

}
