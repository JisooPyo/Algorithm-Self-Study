package programmers.test2304.test230426;

public class Basic124 {

	public static void main(String[] args) {
		Basic124 b = new Basic124();

		String[] strArr = { "a", "bc", "d", "efg", "hi" };
		
		System.out.println(b.solution(strArr));

	}

	public int solution(String[] strArr) {
		int[] index = new int[31];
		int max = 0;
		for (int i = 0; i < strArr.length; i++) {
			index[strArr[i].length()]++;
		}
		for (int i = 0; i < index.length; i++) {
			if (max < index[i]) {
				max = index[i];
			}
		}
		return max;
	}

}
