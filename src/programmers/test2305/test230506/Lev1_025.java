package programmers.test2305.test230506;

public class Lev1_025 {

	public static void main(String[] args) {
		Lev1_025 lev = new Lev1_025();

		System.out.println(lev.solution(13, 17));
		System.out.println(lev.solution(24, 27));

	}

	public int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			int divisor_num = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					divisor_num++;
				}
			}
			if (divisor_num % 2 == 0) {
				answer += i;
			} else {
				answer -= i;
			}
		}

		return answer;
	}

}

/*

다른 사람의 풀이
제곱수는 약수의 개수가 홀수개!

    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left;i<=right;i++) {
        
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            else {
                answer += i;
            }
            
        }
        return answer;
    }

*/