package programmers.test2304.test230420;

public class ProliferationOfBacteriaProblem {

	public static void main(String[] args) {

		ProliferationOfBacteriaProblem pob = new ProliferationOfBacteriaProblem();

		System.out.println(pob.solution(2, 10));
		System.out.println(pob.solution(7, 15));

	}

	public int solution(int n, int t) {
		int answer = n;
		for (int i = 1; i <= t; i++) {
			answer = answer*2;
		}
		return answer;
	}

}

/*

다른 사람의 풀이
비트 쉬프트(Shift) 연산자 활용

    public int solution(int n, int t) {
        int answer = 0;

        answer = n << t;

        return answer;
    }

*/