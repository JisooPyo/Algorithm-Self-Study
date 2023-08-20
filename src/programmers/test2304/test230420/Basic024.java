package programmers.test2304.test230420;

import java.util.Arrays;

public class Basic024 {

	public static void main(String[] args) {
		
		Basic024 b = new Basic024();
		
		String x = "i love you";
		String y = "programmers";
		
		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}
	
    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");
        return answer;
    }

}

// String.split 이용