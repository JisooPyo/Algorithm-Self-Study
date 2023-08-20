package programmers.test2304.test230422;

public class Basic062 {

	public static void main(String[] args) {
		Basic062 b = new Basic062();

		String x = "abc1abc1abc";

		System.out.println(b.solution(x));

	}

	public String solution(String code) {
		String answer = "";
		int mode = 0;

		for (int i = 0; i < code.length(); i++) {
			if (mode == 0) {
				if (code.charAt(i) == '1') {
					mode = 1;
				} else if (i % 2 == 0) {
					answer += code.charAt(i);
				} 
			} else if(mode == 1){
				if (code.charAt(i) == '1') {
					mode = 0;
				} else if (i % 2 == 1) {
					answer += code.charAt(i);
				} 
			} 

		}

		return answer.equals("")?"EMPTY":answer;
	}

}
