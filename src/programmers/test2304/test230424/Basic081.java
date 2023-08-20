package programmers.test2304.test230424;

import java.util.Arrays;

public class Basic081 {

	public static void main(String[] args) {
		Basic081 b = new Basic081();
		
		String x = "Bcad";
		String y = "heLLo";
		String z = "Python";
		
		System.out.println(b.solution(x));
		System.out.println(b.solution(y));
		System.out.println(b.solution(z));

	}
	
    public String solution(String my_string) {
        String answer = my_string.toLowerCase();
        String[] sp = answer.split("");
        Arrays.sort(sp);
        answer = String.join("", sp);
        return answer;
    }

}

/*

새로 배운 메소드
String.join("",sp) : sp array를 ""으로 묶어 String으로 만든다.

다른 사람의 풀이

char[]를 바로 String으로 변환하는게 가능했다!!
 
    public String solution(String my_string) {
        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

*/
