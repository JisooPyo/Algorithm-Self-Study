package programmers.test2304.test230420;

import java.util.Scanner;

public class Basic012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String answer = "";

		if (n % 2 == 0) {
			answer += "even";
		} else {
			answer += "odd";
		}

		System.out.println(n + " is " + answer);

	}

}
