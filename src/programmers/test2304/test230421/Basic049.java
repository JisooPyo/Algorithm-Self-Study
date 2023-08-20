package programmers.test2304.test230421;

public class Basic049 {

	public static void main(String[] args) {

		Basic049 b = new Basic049();

		int[] x = { 3, 4, 5, 2, 1 };
		int[] y = { 5, 7, 8, 3 };

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public int solution(int[] num_list) {
		int sum = 0;
		int multiple = 1;
		for (int i = 0; i < num_list.length; i++) {
			multiple *= num_list[i];
			sum += num_list[i];
		}
		sum = sum * sum;
		return multiple < sum ? 1 : 0;
	}

}
