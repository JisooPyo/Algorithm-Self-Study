package programmers.test2304.test230420;

public class Basic016 {

	public static void main(String[] args) {
		
		Basic016 b = new Basic016();
		
		String x = "ProgrammerS123";	
		String y = "He110W0r1d";
		
		System.out.println(b.solution(x, 11));
		System.out.println(b.solution(y, 5));
		

	}
	
    public String solution(String my_string, int n) {
        return my_string.substring(my_string.length()-n);
    }

}
