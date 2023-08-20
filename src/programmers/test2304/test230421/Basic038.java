package programmers.test2304.test230421;

public class Basic038 {

	public static void main(String[] args) {

		Basic038 b = new Basic038();

		System.out.println(b.solution(9, 91));
		System.out.println(b.solution(89, 8));

	}

	public int solution(int a, int b) {
		int answer = 0;
		
		String merge = Integer.toString(a) + Integer.toString(b);
		String merge2 = Integer.toString(b) + Integer.toString(a);
		
		int mer = Integer.valueOf(merge);
		int mer2 = Integer.valueOf(merge2);
		
		answer = mer >= mer2 ? mer : mer2;

		return answer;
	}

}
