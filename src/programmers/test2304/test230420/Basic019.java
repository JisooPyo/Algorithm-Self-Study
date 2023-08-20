package programmers.test2304.test230420;

public class Basic019 {

	public static void main(String[] args) {
		Basic019 b = new Basic019();

		boolean[] x = { true, false, false, true, true };
		boolean[] y = { false, false, false, true, false, false, false };

		System.out.println(b.solution(3, 4, x));
		System.out.println(b.solution(7, 1, y));

	}

	public int solution(int a, int d, boolean[] included) {
		int answer = 0;
		int[] seq = new int[included.length];

		for (int i = 0; i < seq.length; i++) {
			seq[i] = a + i * d;
		}

		for (int i = 0; i < seq.length; i++) {
			if (included[i] == true) {
				answer += seq[i];
			}
		}
		
		return answer;
	}

}

/*

다른 사람의 풀이
if 안의 조건식을 그냥 이렇게 해도 ok!

 if (included[i])
                answer += array[i];

*/