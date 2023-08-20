package programmers.test2306.test230621;

public class SkillTest1Problem1 {
	public static void main(String[] args) {
		SkillTest1Problem1 p = new SkillTest1Problem1();

		System.out.println(p.solution("AB", 1));
		System.out.println(p.solution("z", 1));
		System.out.println(p.solution("a B z", 4));

	}

	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isLowerCase(ch)) {
				ch = (int)(ch + n) > 122 ? (char)(ch + n - 26) : (char)(ch + n);
			} else if (Character.isUpperCase(ch)) {
				ch = (int)(ch + n) > 90 ? (char)(ch + n - 26) : (char)(ch + n);
			}
			sb.append(ch);
		}

		return sb.toString();
	}
}
