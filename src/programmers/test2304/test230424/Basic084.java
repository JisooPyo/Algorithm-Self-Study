package programmers.test2304.test230424;

import java.util.ArrayList;
import java.util.List;

public class Basic084 {

	public static void main(String[] args) {
		Basic084 basic = new Basic084();

		String x = "aAb1B2cC34oOp";
		String y = "1a2b3c4d123Z";
		
		System.out.println(basic.solution(x));
		System.out.println(basic.solution(y));

	}

	public int solution(String my_string) {
		String[] s = my_string.split("[a-zA-Z]");
		List<Integer> s2 = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			if(!(s[i].equals(""))){
				s2.add(Integer.parseInt(s[i]));
			}
		}
		return s2.stream().mapToInt(Integer::intValue).sum();
	}

}

/*

자바 정규식 
[^a-z] : 알파벳 소문자 a부터 z까지를 제외한 모든 문자
[a-z] : 알파벳 소문자 a부터 z까지 하나
[a-z0-9] : 알파벳 소문자 전체,0~9 중 한 문자
^a : a로 시작하는 단어
a$ : a로 끝나는 단어

참고 : https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%A0%95%EA%B7%9C%EC%8B%9DRegular-Expression-%EC%82%AC%EC%9A%A9%EB%B2%95-%EC%A0%95%EB%A6%AC

----------------------------------------------------------------

다른 사람의 풀이 1)

String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");

---------------------------------------------------------------

다른 사람의 풀이 2)

StringTokenizer 클래스 사용

참고 : https://jhnyang.tistory.com/entry/JAVA-StringTokenizer-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A1%9C-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%B6%84%EB%A6%AC%ED%95%98%EA%B8%B0-split-%EB%B9%84%EA%B5%90

    public int solution(String my_string) {
        int answer = 0;
        String s = my_string.replaceAll("[^0-9]", " ");
        StringTokenizer st = new StringTokenizer(s, " ");

        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }

        return answer;
    }

*/