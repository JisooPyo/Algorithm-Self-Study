package programmers.test2304.test230413;

public class GetRidOfLetterProblem {

	public static void main(String[] args) {

		GetRidOfLetterProblem g = new GetRidOfLetterProblem();

		String x1 = "abcdef";
		String x2 = "f";
		String y1 = "BCBdbe";
		String y2 = "B";
		

		System.out.println(g.solution(x1, x2));
		System.out.println(g.solution(y1, y2));
		
	}

	public String solution(String my_string, String letter) {
		
		return my_string.replaceAll(letter, "");
	}

}

/*

my_string.indexOf(letter) -> my_string에서 letter가 있는 자리
System.out.println(y1.indexOf("B"));	// 0
System.out.println(y1.indexOf("B",0));	// 0
System.out.println(y1.indexOf("B",1));	// 2

my_string.replaceAll(letter, "") -> my_string에서 letter를 ""로 다 바꿔주세요.

*/
