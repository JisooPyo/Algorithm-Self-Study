// 문자열을 정수로 바꾸기

package programmers.test2305.test230504;

public class Lev1_010 {

	public static void main(String[] args) {
		Lev1_010 lev = new Lev1_010();

		System.out.println(lev.solution("+12345"));
		System.out.println(lev.solution("-12345"));
		System.out.println(lev.solution("12345"));

		String ex = "+12345";

		System.out.println(ex.charAt(0) == '+');

	}

	public int solution(String s) {
//		if (s.charAt(0) == '+') {
//			return Integer.parseInt(s.substring(1));
//		} else if (s.charAt(0) == '-') {
//			return (-1) * Integer.parseInt(s.substring(1));
//		}
		return Integer.parseInt(s);
	}

}

/*

if문을 쓸 필요가 없었다...! Integer.parseInt()는 부호까지 같이 인식을 해준다!!

 */
