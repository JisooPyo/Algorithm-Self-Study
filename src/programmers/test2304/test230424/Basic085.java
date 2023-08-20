package programmers.test2304.test230424;

public class Basic085 {

	public static void main(String[] args) {
		Basic085 basic = new Basic085();

		String x1 = "10";
		String x2 = "11";
		String y1 = "1001";
		String y2 = "1111";

		System.out.println(basic.solution(x1, x2));
		System.out.println(basic.solution(y1, y2));
		
	}

	public String solution(String bin1, String bin2) {
		String answer = "";
		int x = Integer.parseInt(bin1);
		int y = Integer.parseInt(bin2);
		int a = 0;
		int b = 0;
		int place = 1;

		while (x > 0) {
			if (x % 10 == 1) {
				a += place;
			}
			place *= 2;
			x = x / 10;
		}
		place = 1;

		while (y > 0) {
			if (y % 10 == 1) {
				b += place;
			}
			place *= 2;
			y = y / 10;
		}

		int sum = a + b;

		while (sum > 0) {
			answer = (sum % 2) + answer;
			sum = sum / 2;
		}

		return answer.equals("") ? "0" : answer;
	}

}

/*

다른 사람의 풀이

    public String solution(String bin1, String bin2) {
        return Integer.toString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2),2);
    }


*/