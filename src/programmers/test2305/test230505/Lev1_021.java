// 가운데 글자 가져오기
package programmers.test2305.test230505;

public class Lev1_021 {

	public static void main(String[] args) {

		Lev1_021 lev = new Lev1_021();

		String t1 = "abcde";
		String t2 = "qwer";
		
		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));
		System.out.println(lev.solution("a"));
		

	}

	public String solution(String s) {
		String answer = "";
		int n = s.length();
		if (s.length() % 2 == 0) {
			answer = s.substring(n / 2 - 1, n / 2 + 1);
		} else {
			answer = Character.toString(s.charAt(n / 2));
		}
		return answer;
	}

}

/*

다른 사람의 풀이

return word.substring((word.length()-1)/2, word.length()/2 + 1);

*/