package programmers.test2304.test230425;

import java.util.ArrayList;
import java.util.List;

public class Basic098 {

	public static void main(String[] args) {
		Basic098 b = new Basic098();

		String x = "ihrhbakrfpndopljhygc";
		String y = "programmers";

		System.out.println(b.solution(x, 4, 2));
		System.out.println(b.solution(y, 1, 1));

	}

	public String solution(String my_string, int m, int c) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < my_string.length() / m; i++) {
			list.add(my_string.substring(i * m, i * m + m));
		}
		String[] arr = list.toArray(new String[list.size()]);
		char[] ch = new char[arr.length];
		for (int i = 0; i < ch.length; i++) {
			ch[i] = arr[i].charAt(c - 1);
		}
		return new String(ch);
	}

}

/*

다른 사람의 풀이

    public String solution(String my_string, int m, int c) {
        String answer = "";

        for (int i = c - 1; i < my_string.length(); i += m) {
            answer += my_string.charAt(i);
        }
        return answer;
    }

*/