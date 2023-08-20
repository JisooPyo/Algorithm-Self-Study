/*
문제 설명

머쓱이는 프로그래머스에 로그인하려고 합니다. 머쓱이가 입력한 아이디와 패스워드가 담긴 배열 id_pw와 회원들의 정보가 담긴 2차원 배열 db가 주어질 때,
다음과 같이 로그인 성공, 실패에 따른 메시지를 return하도록 solution 함수를 완성해주세요.
  * 아이디와 비밀번호가 모두 일치하는 회원정보가 있으면 "login"을 return합니다.
  * 로그인이 실패했을 때 아이디가 일치하는 회원이 없다면 “fail”를, 아이디는 일치하지만 비밀번호가 일치하는 회원이 없다면 “wrong pw”를 return 합니다.

제한사항

회원들의 아이디는 문자열입니다.
회원들의 아이디는 알파벳 소문자와 숫자로만 이루어져 있습니다.
회원들의 패스워드는 숫자로 구성된 문자열입니다.
회원들의 비밀번호는 같을 수 있지만 아이디는 같을 수 없습니다.
id_pw의 길이는 2입니다.
id_pw와 db의 원소는 [아이디, 패스워드] 형태입니다.
1 ≤ 아이디의 길이 ≤ 15
1 ≤ 비밀번호의 길이 ≤ 6
1 ≤ db의 길이 ≤ 10
db의 원소의 길이는 2입니다.
 */
package programmers.test2304.test230430;

public class Lev0_16 {

	public static void main(String[] args) {
		Lev0_16 lev = new Lev0_16();

		String[] t1 = { "meosseugi", "1234" };
		String[][] t2 = { { "rardss", "123" }, { "yyoom", "1234" }, { "meosseugi", "1234" } };

		String[] t3 = { "programmer01", "15789" };
		String[][] t4 = { { "programmer02", "111111" }, { "programmer00", "134" }, { "programmer01", "1145" } };

		String[] t5 = { "rabbit04", "98761" };
		String[][] t6 = { { "jaja11", "98761" }, { "krong0313", "29440" }, { "rabbit00", "111333" } };

		System.out.println(lev.solution(t1, t2));
		System.out.println(lev.solution(t3, t4));
		System.out.println(lev.solution(t5, t6));

	}

	public String solution(String[] id_pw, String[][] db) {
		boolean id = false;
		int index = 0;

		for (int i = 0; i < db.length; i++) {
			if (id_pw[0].equals(db[i][0])) {
				id = true;
				index = i;
			}
		}

		if (id) {
			boolean password = false;
			if (id_pw[1].equals(db[index][1])) {
				password = true;
			}
			return password ? "login" : "wrong pw";
		} else {
			return "fail";
		}
	}

}

//1, 5 실패 --> id와 password를 다른 index에서 비교했다.. 이쪽 저쪽 다 for문을 써서 실수!