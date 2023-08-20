package programmers.test2305.test230504;

public class Lev1_012 {

	public static void main(String[] args) {
		Lev1_012 lev = new Lev1_012();

		System.out.println(lev.solution(10));
		System.out.println(lev.solution(12));
		System.out.println(lev.solution(11));
		System.out.println(lev.solution(13));

	}

	public boolean solution(int x) {
		int sum = 0;
		int temp = x;
		while (temp > 0) {
			sum += temp % 10;
			temp = temp / 10;
		}
		return x % sum == 0 ? true : false;
	}

}
