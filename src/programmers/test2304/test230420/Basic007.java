package programmers.test2304.test230420;

import java.util.Scanner;

public class Basic007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = "";
		for (int i = 0; i < a.length(); i++) {
			if (Character.isUpperCase(a.charAt(i))) {
				b += Character.toLowerCase(a.charAt(i));
			} else {
				b += Character.toUpperCase(a.charAt(i));
			}
		}
		System.out.println(b);
	}
}
