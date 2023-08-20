package programmers.test2304.test230421;

public class Basic042 {

	public static void main(String[] args) {
		Basic042 b = new Basic042();
		
		String x = "aBcDeFg";
		String y = "AAA";
		
		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}
	
    public String solution(String myString) {
        return myString.toUpperCase();
    }

}
