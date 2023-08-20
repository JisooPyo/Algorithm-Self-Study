package programmers.test2304.test230414;

public class MorseCodeProblem {

	public static void main(String[] args) {

		MorseCodeProblem mc = new MorseCodeProblem();

		String x1 = ".... . .-.. .-.. ---";
		String x2 = ".--. -.-- - .... --- -.";

		System.out.println(mc.solution(x1));
		System.out.println(mc.solution(x2));

	}

	public String solution(String letter) {

		String[] before = letter.split(" "); // {"....",".",".-..",.-..","---"}

		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		for (int j = 0; j < before.length; j++) {
			for (int i = 0; i < 26; i++) {
				if (before[j].equals(morse[i])) { // 스트링값은 ==으로 비교하지 말 것..!!
					before[j] = alphabet[i];
				}

			}
		}

		String answer = String.join("", before);

		return answer;

	}

}

/*
 * 
 * 1. ==은 object를 비교하는 것이므로, 스트링을 비교할 때는 ==으로 비교하지 말 것.
 * 
 * 2. split() 메소드 String[] before = letter.split(" "); String letter을 띄어쓰기를 기준으로
 * 나누어 before배열에 저장해주세요.
 * 
 * 3. join() 메소드 String answer = String.join("",ans); String배열 ans를 사이사이 ""를 넣어
 * String으로 만들어주세요.
 * 
 */