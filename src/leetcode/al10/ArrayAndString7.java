package leetcode.al10;

public class ArrayAndString7 {
	public static void main(String[] args) {
		ArrayAndString7 aas7 = new ArrayAndString7();

		System.out.println(aas7.addBinary("11", "1"));
		System.out.println(aas7.addBinary("1010", "1011"));
	}

	public String addBinary(String a, String b) {
		StringBuilder sb1 = new StringBuilder(a);
		StringBuilder sb2 = new StringBuilder(b);
		sb1.reverse();
		sb2.reverse();
		if (a.length() > b.length()) {
			for (int i = 1; i <= (a.length() - b.length()); i++) {
				sb2.append(0);
			}
		} else {
			for (int i = 1; i <= b.length() - a.length(); i++) {
				sb1.append(0);
			}
		}
		StringBuilder ans = new StringBuilder();
		boolean regroup = false;
		for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
			int num;
			if (regroup) {
				num = sb1.charAt(i) - '0' + sb2.charAt(i) - '0' + 1;
			} else {
				num = sb1.charAt(i) - '0' + sb2.charAt(i) - '0';
			}
			regroup = num >= 2 ? true : false;
			ans.append(num % 2);
		}
		if (regroup) {
			ans.append(1);
		}

		return ans.reverse().toString();
	}
}
