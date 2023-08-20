package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic115 {

	public static void main(String[] args) {
		Basic115 b = new Basic115();

		String x = "axbxcxdx";
		String y = "dxccxbbbxaaaa";

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public String[] solution(String myString) {

		List<String> list = new ArrayList<>();
		String[] split = myString.split("x+");

		for (int i = 0; i < split.length; i++) {
			if (!(split[i].equals(""))) {
				list.add(split[i]);
			}
		}

		String[] answer = list.toArray(new String[list.size()]);
		Arrays.sort(answer);

		return answer;
	}

}
