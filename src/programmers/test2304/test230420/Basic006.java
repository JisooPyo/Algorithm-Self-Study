package programmers.test2304.test230420;

import java.util.Scanner;

public class Basic006 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = sc.nextInt();
		String answer = "";
		for (int i = 1; i <= n; i++) {
			answer += str;
		}
		System.out.println(answer);

	}

}
/*

다른 사람의 풀이

str.repeat(n)를 이용해서 했다..!

*/
