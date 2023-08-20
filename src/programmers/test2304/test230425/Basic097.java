package programmers.test2304.test230425;

public class Basic097 {

	public static void main(String[] args) {
		Basic097 b = new Basic097();

		String x = "Progra21Sremm3";
		String y = "Stanley1yelnatS";

		System.out.println(b.solution(x, 6, 12));
		System.out.println(b.solution(y, 4, 10));

	}

	public String solution(String my_string, int s, int e) {
		String answer = my_string;
		char[] b = my_string.toCharArray();
		char[] c = answer.toCharArray();
		for (int i = s; i <= e; i++) {
			c[i]=b[s+e-i];
		}
		return new String(c);
	}

}

/*

다른 사람의 풀이

    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string.substring(s, e + 1));
        answer.reverse();
        return my_string.substring(0, s) + answer + my_string.substring(e + 1);
    }

*/