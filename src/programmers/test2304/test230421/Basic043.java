package programmers.test2304.test230421;

public class Basic043 {

	public static void main(String[] args) {
		Basic043 b = new Basic043();

		String x = "ProgrammerS123";
		String y = "He110W0r1d";

		System.out.println(b.solution(x, 11));
		System.out.println(b.solution(y, 5));

	}

	public String solution(String my_string, int n) {
		String answer = "";
		for (int i = 0; i < n; i++) {
			answer += my_string.charAt(i);
		}
		return answer;
	}

}

/*

다른 사람의 풀이!

    public String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }

*/
