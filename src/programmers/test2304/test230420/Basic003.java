package programmers.test2304.test230420;

public class Basic003 {

	public static void main(String[] args) {
		
		Basic003 b = new Basic003();
		
		System.out.println(b.solution("aBcDeFg"));
		System.out.println(b.solution("aaa"));

	}
	
    public String solution(String myString) {
        return myString.toLowerCase();
    }

}
