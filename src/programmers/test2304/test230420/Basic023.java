package programmers.test2304.test230420;

public class Basic023 {

	public static void main(String[] args) {
		Basic023 b = new Basic023();

		int[] x = { 12, 4, 15, 46, 38, -2, 15 };
		int[] y = { 13, 22, 53, 24, 15, 6 };
		
		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public int solution(int[] num_list) {
		int answer = -1;
		for(int i=0;i<num_list.length;i++) {
			if(num_list[i]<0) {
				answer = i;
				break;
			}
		}
		return answer;
	}

}
