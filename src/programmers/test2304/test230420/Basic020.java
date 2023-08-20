package programmers.test2304.test230420;

import java.math.BigInteger;

public class Basic020 {

	public static void main(String[] args) {

		Basic020 b = new Basic020();

		String x1 = "582";
		String x2 = "734";
		String y1 = "18446744073709551615";
		String y2 = "287346502836570928366";
		String z1 = "0";
		String z2 = "0";

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));
		System.out.println(b.solution(z1, z2));

	}

	public String solution(String a, String b) {
		BigInteger a2 = new BigInteger(a);
		BigInteger b2 = new BigInteger(b);
		return a2.add(b2).toString();
	}
}

/*

자릿수가 10만이 넘어가므로 long보다 더 큰 형태의 정수를 다루려면 BigInteger를 사용해주어야 함!

*/