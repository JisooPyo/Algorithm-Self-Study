package leetcode.al10;

public class ArrayAndString9 {
	public static void main(String[] args) {
		ArrayAndString9 aas9 = new ArrayAndString9();

		String[] strs1 = {"flower", "flow", "flight"};
		String[] strs2 = {"dog", "racecar", "car"};

		System.out.println("strs1 : " + aas9.longestCommonPrefix(strs1));
		System.out.println("strs2 : " + aas9.longestCommonPrefix(strs2));

	}

	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder(strs[0]);
		if (strs.length == 1) {
			return sb.toString();
		}

		loop1:
		for (int i = 1; i < strs.length; i++) {
			if (sb.length() == 0) {
				break;
			}
			for (int j = 0; j < Math.min(sb.length(), strs[i].length()); j++) {
				if (sb.charAt(j) != strs[i].charAt(j)) {
					sb.delete(j, sb.length());
					continue loop1;
				}
			}
			if (sb.length() > strs[i].length()) {
				sb = new StringBuilder(strs[i]);
			}

		}
		return sb.toString();
	}

	// 다른 사람의 풀이
	// 나는 for문 안에 for문이 다 돌아가는 구조이지만 여기서는 while문의 조건에 걸려서
	// 초기에 접두사만 잘 만들어지면 몇 번 돌지 않는다.
	public String longestCommonPrefix2(String[] strs) {
		String res = strs[0];
		for (String s : strs) {
			while (s.indexOf(res) != 0) {
				res = res.substring(0, res.length() - 1);
			}
		}
		return res;
	}
}
