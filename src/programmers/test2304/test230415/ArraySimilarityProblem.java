package programmers.test2304.test230415;

public class ArraySimilarityProblem {

	public static void main(String[] args) {

		ArraySimilarityProblem as = new ArraySimilarityProblem();

		String[] x1 = { "a", "b", "c" };
		String[] x2 = { "com", "b", "d", "p", "c" };
		String[] y1 = { "n", "omg" };
		String[] y2 = { "m", "dot" };

		System.out.println(as.solution(x1, x2));
		System.out.println(as.solution(y1, y2));

	}

	public int solution(String[] s1, String[] s2) {

		int answer = 0;
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				if (s1[i].equals(s2[j])) {
					answer++;
				}
			}
		}
		return answer;
	}

}
