package programmers.test2304.test230415;

public class CountDiceProblem {

	public static void main(String[] args) {

		CountDiceProblem cd = new CountDiceProblem();

		int[] x1 = { 1, 1, 1 };
		int x2 = 1;

		int[] y1 = { 10, 8, 6 };
		int y2 = 3;

		System.out.println(cd.solution(x1, x2));
		System.out.println(cd.solution(y1, y2));

	}

	public int solution(int[] box, int n) {

		return (box[0] / n) * (box[1] / n) * (box[2] / n);
	}

}
