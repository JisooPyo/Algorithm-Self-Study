// 직사각형 만들기

package programmers.test2305.test230506;

import java.util.Scanner;

public class Lev1_029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		String line = "";
		for (int i = 1; i <= a; i++) {
			line += "*";
		}
		for (int i = 1; i <= b; i++) {
			System.out.println(line);
		}

	}

}
