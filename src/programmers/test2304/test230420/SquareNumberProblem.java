package programmers.test2304.test230420;

public class SquareNumberProblem {

	public static void main(String[] args) {

		SquareNumberProblem sn = new SquareNumberProblem();

		System.out.println(sn.solution(144));
		System.out.println(sn.solution(976));

	}

	public int solution(int n) {
		int answer = 2;
		for (int i = 1; i * i <= n; i++) {
			if(i*i==n) {
				answer = 1;
			}
		}
		return answer;
	}

}

/*

 다른 사람의 풀이
 
 Math 클래스의 sqrt 메소드 사용
 
     public int solution(int n) {
        if (n % Math.sqrt(n) == 0) {
            return 1;
        } else {
            return 2;
        }
    }
 
 */