// 음양 더하기
package programmers.test2305.test230505;

public class Lev1_018 {

	public static void main(String[] args) {
		Lev1_018 lev = new Lev1_018();

		boolean t = true;
		boolean f = false;

		int[] t1 = { 4, 7, 12 };
		boolean[] t1_signs = { t, f, t };
		int[] t2 = { 1, 2, 3 };
		boolean[] t2_signs = { f, f, t };

		System.out.println(lev.solution(t1, t1_signs));
		System.out.println(lev.solution(t2, t2_signs));

	}

	public int solution(int[] absolutes, boolean[] signs) {
		int sum = 0;
		for (int i = 0; i < signs.length; i++) {
			if (signs[i]) {
				sum += absolutes[i];
			} else {
				sum -= absolutes[i];
			}
		}
		return sum;
	}

}

/*

다른 사람의 풀이
곱하기할 수에 삼항연산자를 넣었다!

public int solution(int[] absolutes, boolean[] signs) {
    int answer = 0;
    for (int i=0; i<signs.length; i++)
        answer += absolutes[i] * (signs[i]? 1: -1);
    return answer;
}

*/