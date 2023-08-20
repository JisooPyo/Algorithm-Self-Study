// 삼총사

package programmers.test2305.test230508;

public class Lev1_036 {

	public static void main(String[] args) {
		Lev1_036 lev = new Lev1_036();

		int[] t1 = { -2, 3, 0, 2, -5 };
		int[] t2 = { -3, -2, -1, 0, 1, 2, 3 };
		int[] t3 = { -1, 1, -1, 1 };
		int[] t4 = { -1, 0, 1 };

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));
		System.out.println(lev.solution(t3));
		System.out.println(lev.solution(t4));

	}

	public int solution(int[] number) {
		int answer = 0;
		int n = number.length;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (number[i] + number[j] + number[k] == 0) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

}
