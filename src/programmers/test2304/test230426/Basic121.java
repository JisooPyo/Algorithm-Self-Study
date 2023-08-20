package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic121 {

	public static void main(String[] args) {
		Basic121 b = new Basic121();

		String x = "baconlettucetomato";
		String y = "abcd";
		String z = "cabab";

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));
		System.out.println(Arrays.toString(b.solution(z)));

	}

	public String[] solution(String myStr) {

		String[] answer = myStr.split("a|b|c");
		List<String> list = new ArrayList<>();

		if (answer.length == 0) {
			return new String[] { "EMPTY" };
		} else {
			for (int i = 0; i < answer.length; i++) {
				if (answer[i].length() != 0) {
					list.add(answer[i]);
				}
			}
			return list.toArray(new String[list.size()]);
		}

	}

}
