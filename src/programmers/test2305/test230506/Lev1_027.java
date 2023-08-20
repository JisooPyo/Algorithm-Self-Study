// 문자열 다루기 기본

package programmers.test2305.test230506;

public class Lev1_027 {

	public static void main(String[] args) {
		Lev1_027 lev = new Lev1_027();

		System.out.println(lev.solution("a234"));
		System.out.println(lev.solution("1234"));

	}

	public boolean solution(String s) {
		if (s.length() == 4 || s.length() == 6) {
			s = s.replaceAll("^[0-9]*$", "");
			return s.length() == 0 ? true : false;
		} else {
			return false;
		}
	}

}

//5, 6, 28, 29 틀림..!

// 정규식 [0-9] => ^[0-9]*$로 바꾼 뒤 여전히 같은 문제 틀림

// 문제를 다시 보니 '문자열 s의 길이가 4 혹은 6이고'라는 조건이 있어서 조건을 추가해주니 다 맞음.