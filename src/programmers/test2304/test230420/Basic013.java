package programmers.test2304.test230420;

public class Basic013 {

	public static void main(String[] args) {
		Basic013 b = new Basic013();
		
		String x1 = "He11oWor1d";
		String x2 = "lloWorl";
		int x3 = 2;
		
		String y1 = "Program29b8UYP123456";
		String y2 = "merS123";
		int y3 = 7;
		
		System.out.println(b.solution(x1, x2, x3));
		System.out.println(b.solution(y1, y2, y3));

	}

	public String solution(String my_string, String overwrite_string, int s) {
		String answer = "";
		answer+=my_string.substring(0, s);
		answer+=overwrite_string;
		int endindex = s + overwrite_string.length();
		answer+=my_string.substring(endindex);
		return answer;
	}

}

/*

다른 사람의 풀이

    public String solution(String my_string, String overwrite_string, int s) {
        String before = my_string.substring(0, s);
        String after = my_string.substring(s + overwrite_string.length());
        return before + overwrite_string + after;
    }

*/
