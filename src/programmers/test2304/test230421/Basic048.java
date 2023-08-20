package programmers.test2304.test230421;

public class Basic048 {

	public static void main(String[] args) {

		Basic048 b = new Basic048();

		String x1 = "programmers";
		String x2 = "p";
		String y1 = "lowercase";
		String y2 = "x";

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));
	}

	public String solution(String my_string, String alp) {
		String answer = "";
		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.charAt(i) == alp.charAt(0)) {
				answer += Character.toUpperCase(my_string.charAt(i));
			} else {
				answer += my_string.charAt(i);
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

public String solution(String my_string, String alp) {

        char c = Character.toUpperCase(alp.charAt(0));
        
        if (my_string.contains(alp)) {
            return my_string.replace(alp.charAt(0), c);
        
        } else {
            return my_string;
        }
    }

*/