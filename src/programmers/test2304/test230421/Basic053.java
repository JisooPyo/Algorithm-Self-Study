package programmers.test2304.test230421;

public class Basic053 {

	public static void main(String[] args) {

		Basic053 b = new Basic053();

		String x1 = "cvsgiorszzzmrpaqpe";
		int[] x2 = { 16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7 };

		String y1 = "zpiaz";
		int[] y2 = { 1, 2, 0, 0, 3 };

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));
	}

	public String solution(String my_string, int[] index_list) {
		String answer = "";
		for (int i = 0; i < index_list.length; i++) {
			answer += my_string.charAt(index_list[i]);
		}
		return answer;
	}

}
