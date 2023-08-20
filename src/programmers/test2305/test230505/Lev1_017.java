package programmers.test2305.test230505;

public class Lev1_017 {

	public static void main(String[] args) {

		Lev1_017 lev = new Lev1_017();

		String t1 = "01033334444";
		String t2 = "027778888";

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));

	}

	public String solution(String phone_number) {
		String answer = "";
		for (int i = 1; i <= phone_number.length() - 4; i++) {
			answer += "*";
		}
		answer += phone_number.substring(phone_number.length() - 4);
		return answer;
	}

}

/*
 * 
 * 다른 사람의 풀이 toCharArray로 바꾼 뒤 배열의 각 원소를 '*'로 바꿔주기!
 * 
 * public String solution(String phone_number) { char[] ch =
 * phone_number.toCharArray(); for(int i = 0; i < ch.length - 4; i ++){ ch[i] =
 * '*'; } return String.valueOf(ch); }
 * 
 * ------------------------------------------------ . -> 임의의 문자 한 개 (?=.) -> 뒷쪽에
 * 임의의 문자 한 개를 제외하고 선택( =앞 문자를 기준으로 전방 탐색 ) {숫자} -> 숫자 만큼의 자릿수(n개 있다) .(?=.{4})
 * ==> 뒤쪽에서 임의의 문자 4개를 제외한 임의의 문자 한 개 선택
 * 
 * public String solution(String phone_number) { return
 * phone_number.replaceAll(".(?=.{4})", "*"); }
 * 
 */