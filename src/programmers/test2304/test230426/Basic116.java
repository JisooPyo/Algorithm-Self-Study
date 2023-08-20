package programmers.test2304.test230426;

public class Basic116 {

	public static void main(String[] args) {
		Basic116 b = new Basic116();

		String x = "0010";
		String y = "854020";

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public String solution(String n_str) {
		int x1 = Integer.parseInt(n_str);
		String x2 = Integer.toString(x1);
		return x2;
	}

}
/*

다른 사람의 풀이

return ""+Integer.parseInt(n_str); // 깔끔!!

*/