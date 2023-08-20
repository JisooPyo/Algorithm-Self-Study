package programmers.test2304.test230421;

public class Basic037 {

	public static void main(String[] args) {

		Basic037 b = new Basic037();

		String[] x = { "a", "b", "c" };
		System.out.println(b.solution(x));

	}

	public String solution(String[] arr) {
		String answer = "";
		
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}

		return answer;
	}

}
