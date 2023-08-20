package programmers.test2304.test230414;

public class BallShareProblem {

	public static void main(String[] args) {

		BallShareProblem bs = new BallShareProblem();

		int b1 = 3;
		int s1 = 2;
		int b2 = 5;
		int s2 = 3;

		System.out.println(bs.solution(b1, s1));
		System.out.println(bs.solution(b2, s2));
		System.out.println(bs.solution(30, 29));
		System.out.println(bs.solution(30, 15));

	}

	public int solution(int balls, int share) {

		int b = 1;
		int s = 1;
		int answer = 1;
		int rest = balls - share;

		if (share >= rest) {

			for (int i = 0; i < rest; i++) {
				b = b * (balls - i);
				s = s * (rest - i);
				
				if(b%2==0 && s%2==0) {
					b= b/2;
					s=s/2;
				}
				if(b%3==0 && s%3==0) {
					b= b/3;
					s=s/3;
				}
				if(b%5==0 && s%5==0) {
					b= b/5;
					s=s/5;
				}
				if(b%7==0 && s%7==0) {
					b= b/7;
					s=s/7;
				}
				if(b%11==0 && s%11==0) {
					b= b/11;
					s=s/11;
				}
				if(b%13==0 && s%13==0) {
					b= b/13;
					s=s/13;
				}
				if(b%17==0 && s%17==0) {
					b= b/17;
					s=s/17;
				}
				if(b%19==0 && s%19==0) {
					b= b/19;
					s=s/19;
				}

			}

		} else {
			for (int i = 0; i < share; i++) {
				b = b * (balls - i);
				s = s * (share - i);
				
				if(b%2==0 && s%2==0) {
					b= b/2;
					s=s/2;
				}
				if(b%3==0 && s%3==0) {
					b= b/3;
					s=s/3;
				}
				if(b%5==0 && s%5==0) {
					b= b/5;
					s=s/5;
				}
				if(b%7==0 && s%7==0) {
					b= b/7;
					s=s/7;
				}
				if(b%11==0 && s%11==0) {
					b= b/11;
					s=s/11;
				}
				if(b%13==0 && s%13==0) {
					b= b/13;
					s=s/13;
				}
				if(b%17==0 && s%17==0) {
					b= b/17;
					s=s/17;
				}
				if(b%19==0 && s%19==0) {
					b= b/19;
					s=s/19;
				}

			}
		}
		answer = b / s;

		return answer;
	}

}


/*

다른 사람의 풀이 : 재귀함수 사용.

    public long solution(int balls, int share) {
        share = Math.min(balls - share, share);

        if (share == 0)
            return 1;

        long result = solution(balls - 1, share - 1);
        result *= balls;
        result /= share;

        return result;
    }



*/