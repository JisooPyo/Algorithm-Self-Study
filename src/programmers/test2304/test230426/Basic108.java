package programmers.test2304.test230426;

public class Basic108 {

	public static void main(String[] args) {
		Basic108 b = new Basic108();

		String x = "apporoograpemmemprs";
		int[] y = { 1, 16, 6, 15, 0, 10, 11, 3 };

		System.out.println(b.solution(x, y));

	}

	public String solution(String my_string, int[] indices) {
		char[] ch = my_string.toCharArray();
		for (int j = 0; j < indices.length; j++) {
			ch[indices[j]]=' ';
		}
		String answer = new String(ch);
		answer = answer.replace(" ", "");
		return answer;
	}

}

/*

다른 사람의 풀이

StringBuilder sb를 선언하여 indices의 index가 아닌 것만 추가한다.
sb.toString()을 리턴한다.

*/