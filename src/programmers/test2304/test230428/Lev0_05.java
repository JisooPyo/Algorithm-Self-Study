package programmers.test2304.test230428;

public class Lev0_05 {

	public static void main(String[] args) {
		Lev0_05 l = new Lev0_05();

		String x1 = "3x + 7 + x";		 // 4x+7
		String x2 = "x + x + x"; 		// 3x
		String x3 = "0 + 0";			 // 0
		String x4 = "4 + 5";			 // 9
		String x5 = "x + 5 + 3"; 		// x+8
		String x6 = "x + 0";			 // x

		System.out.println(l.solution(x1));
		System.out.println(l.solution(x2));
		System.out.println(l.solution(x3));
		System.out.println(l.solution(x4));
		System.out.println(l.solution(x5));
		System.out.println(l.solution(x6));

	}

	public String solution(String polynomial) {
		int x_sum = 0;
		int num = 0;
		String[] split = polynomial.split(" \\+ ");
		for (int i = 0; i < split.length; i++) {
			if (split[i].contains("x")) {
				if (split[i].equals("x")) {
					x_sum += 1;
				} else {
					x_sum += Integer.parseInt(split[i].substring(0, split[i].length() - 1));
				}
			} else {
				num += Integer.parseInt(split[i]);
			}
		}

		if (x_sum == 0) {
			return num == 0 ? "0" : Integer.toString(num);
		} else if (x_sum == 1) {
			return num == 0 ? "x" : "x + " + num;
		} else {
			return num == 0 ? x_sum + "x" : x_sum + "x + " + num;
		}
	}

}

// 5,6,7,8,10,12 실패
// 8,10,12 실패