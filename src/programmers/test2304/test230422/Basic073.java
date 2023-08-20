package programmers.test2304.test230422;

public class Basic073 {

	public static void main(String[] args) {
		Basic073 b = new Basic073();
		
		String x = "masterpiece";
		String y = "programmers";
		String z = "jerry";
		String w = "burn";
		
		System.out.println(b.solution(x));
		System.out.println(b.solution(y));
		System.out.println(b.solution(z));
		System.out.println(b.solution(w));

	}
	
    public String solution(String rny_string) {
        rny_string = rny_string.replace("m", "rn");
        return rny_string;
    }

}
