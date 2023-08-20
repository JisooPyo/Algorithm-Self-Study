package programmers.test2304.test230424;

public class Basic093 {

	public static void main(String[] args) {
		Basic093 b = new Basic093();
		
		String x = "banana";
		String y1 = "ban";
		String y2 = "nan";
		String y3 = "abcd";
		String y4 = "bananan";
		
		System.out.println(b.solution(x, y1));
		System.out.println(b.solution(x, y2));
		System.out.println(b.solution(x, y3));
		System.out.println(b.solution(x, y4));

	}

	public int solution(String my_string, String is_prefix) {
		return my_string.startsWith(is_prefix) ? 1 : 0;
	}

}
