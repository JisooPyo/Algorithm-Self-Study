/*
문제 설명

머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
문자열 배열 babbling이 매개변수로 주어질 때,
머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.

제한사항

1 ≤ babbling의 길이 ≤ 100
1 ≤ babbling[i]의 길이 ≤ 15

babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
문자열은 알파벳 소문자로만 이루어져 있습니다.
 */

package programmers.test2304.test230430;

public class Lev0_15 {

	public static void main(String[] args) {
		Lev0_15 lev = new Lev0_15();

		String[] t1 = { "aya", "yee", "u", "maa", "wyeoo" };
		String[] t2 = { "ayaye", "uuuma", "ye", "yemawoo", "ayaa" };

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));

	}

	public int solution(String[] babbling) {
		int answer = 0;
		for (int i = 0; i < babbling.length; i++) {
			babbling[i] = babbling[i].replaceAll("aya", "1");
			babbling[i] = babbling[i].replaceAll("ye", "1");
			babbling[i] = babbling[i].replaceAll("woo", "1");
			babbling[i] = babbling[i].replaceAll("ma", "1");
		}

		for (int i = 0; i < babbling.length; i++) {
			babbling[i] = babbling[i].replaceAll("1", "");
		}

		for (int i = 0; i < babbling.length; i++) {
			if (babbling[i].equals("")) {
				answer++;
			}
		}

		return answer;
	}

}

/*
다른 사람의 풀이 - 정규식 이용

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
            				// "(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+"로 시작하고 끝나는 단어(이거로만 이루어져 있는 단어)
            				 * "aya(?!aya) | ye(?!ye) | woo(?!woo) | ma(?!ma)"의 식이 없거나 있거나
            				 * "aya(?!aya)" : 뒤에 aya가 붙지 않는 aya
                answer++;
            }
        }
        return answer;
    }
}

*/