package programmers.test2304.test230420;

public class Basic014 {

	public static void main(String[] args) {

		Basic014 b = new Basic014();

		int[] x1 = { 49, 13 };
		int[] x2 = { 70, 11, 2 };

		int[] y1 = { 100, 17, 84, 1 };
		int[] y2 = { 55, 12, 65, 36 };

		int[] z1 = { 1, 2, 3, 4, 5 };
		int[] z2 = { 3, 3, 3, 3, 3 };

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));
		System.out.println(b.solution(z1, z2));

	}

	public int solution(int[] arr1, int[] arr2) {
		int answer = 0;
		int sum1 = 0;
		int sum2 = 0;
		if (arr1.length > arr2.length) {
			answer = 1;
		} else if (arr2.length > arr1.length) {
			answer = -1;
		} else {
			for (int i = 0; i < arr1.length; i++) {
				sum1 += arr1[i];
				sum2 += arr2[i];
			}
			if (sum1 > sum2) {
				answer = 1;
			} else if (sum2 > sum1) {
				answer = -1;
			} else {
				answer = 0;
			}
		}

		return answer;
	}

}
