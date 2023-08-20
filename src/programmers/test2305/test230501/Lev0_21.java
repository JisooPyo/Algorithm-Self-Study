package programmers.test2305.test230501;

public class Lev0_21 {

	public static void main(String[] args) {
		Lev0_21 lev = new Lev0_21();

		int[] t1 = { 1, 2, 3, 4 };
		int[] t2 = { 2, 4, 8 };

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));
	}

	public int solution(int[] common) {
		if (common[2] - common[1] == common[1] - common[0]) {
			return common[common.length - 1] + common[1] - common[0];

		} else {
			return common[common.length - 1] * (common[1] / common[0]);
		}
	}

}
