package programmers.test2307.test0705;

public class Jisoo {
	public static void main(String[] args) {
		Jisoo jisoo = new Jisoo();
		System.out.println(jisoo.solution("try hello world"));
	}

	public String solution(String s) {
		// s를 소문자로 바꾸고 StringBuilder로 초기화.
		// setCharAt() 메서드를 사용하기 위하여
		StringBuilder sb = new StringBuilder(s.toLowerCase());

		// 단어를 바꾸는 스위치
		boolean flag = false;

		// 한 단어 내의 index
		int index = 0;

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);

			// 공백이면 flag = false, index = 0으로 초기화.
			if (ch == ' ') {
				flag = false;
				index = 0;
			} else {
				flag = true;
			}

			// flag가 true이면 ( 공백이 아니게 되면 )
			if (flag) {

				// index가 짝수일 경우 대문자로 바꾸기
				if (index % 2 == 0) {
					sb.setCharAt(i, (char) (ch - 32));
				}

				// index 하나씩 ++해주기
				index++;
			}
		}

		// String으로 변환하여 return
		return sb.toString();
	}
}

