package programmers.test2304.test230415;

import java.math.BigInteger;

public class BallShareProblemMe {

	public static void main(String[] args) {

		BallShareProblemMe bs = new BallShareProblemMe();

		int b1 = 3;
		int s1 = 2;
		int b2 = 5;
		int s2 = 3;

		System.out.println(bs.solution(b1, s1));
		System.out.println(bs.solution(b2, s2));
		System.out.println(bs.solution(30, 29));
		System.out.println(bs.solution(30, 15));

	}

	public long solution(int balls, int share) {

		BigInteger b = new BigInteger("1");
		BigInteger s = new BigInteger("1");
		
		int rest = Math.min(share, balls-share);

		for (int i = 0; i < rest; i++) {
			
			b = b.multiply(BigInteger.valueOf(balls-i));
			s = s.multiply(BigInteger.valueOf(rest-i));

		}

		BigInteger ans = b.divide(s);
		
		long answer = ans.longValue();

		return answer;
	}

}

// BigInteger 사용법
// https://coding-factory.tistory.com/604
