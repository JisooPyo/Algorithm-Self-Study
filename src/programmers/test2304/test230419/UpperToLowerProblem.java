package programmers.test2304.test230419;

public class UpperToLowerProblem {

	public static void main(String[] args) {
		
		UpperToLowerProblem utl = new UpperToLowerProblem();
		
		String x = "cccCCC";
		String y = "abCdEfghIJ";
		
		System.out.println(utl.solution(x));
		System.out.println(utl.solution(y));
		
	}
	
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<my_string.length();i++) {
        	char c = my_string.charAt(i); 
        	if(Character.isUpperCase(c)) {
        		answer.append(Character.toLowerCase(c));
        	} else {
        		answer.append(Character.toUpperCase(c));
        	}
        }
        return answer.toString();
    }

}

// Character.toLowerCase
// Character.toUpperCase
// Character.isLowerCase
// Character.isUpperCase
/*

다른 사람의 풀이

String.valueOf() : 괄호 안의 객체를 String 객체로 변환시킨다.
String은 +로 더할 수 있다.

    public String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(Character.isUpperCase(c)){
                answer += String.valueOf(c).toLowerCase();
            }else{
                answer += String.valueOf(c).toUpperCase();
            }
        }
        return answer;
    }

*/