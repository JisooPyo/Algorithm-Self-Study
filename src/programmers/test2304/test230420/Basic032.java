package programmers.test2304.test230420;

public class Basic032 {

	public static void main(String[] args) {

		Basic032 b = new Basic032();

		int[] x1 = { 2021, 12, 28 };
		int[] x2 = { 2021, 12, 29 };
		int[] y1 = { 1024, 10, 24 };
		int[] y2 = { 1024, 10, 24 };

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));

	}

	public int solution(int[] date1, int[] date2) {
		if (date1[0] < date2[0]) {
			return 1;
		} else if (date1[0] == date2[0]) {
			if (date1[1] < date2[1]) {
				return 1;
			} else if (date1[1] == date2[1]) {
				if (date1[2] < date2[2]) {
					return 1;
				} else if (date1[2] == date2[2]) {
					return 0;
				} else {
					return 0;
				}
			} else {
				return 0;
			}

		} else {
			return 0;
		}
	}
}

/*

다른 사람의 풀이

    public int solution(int[] date1, int[] date2) {
        int date1Days = date1[0] * 365 + date1[1] * 30 + date1[2];
        int date2Days = date2[0] * 365 + date2[1] * 30 + date2[2];
        return date1Days < date2Days ? 1 : 0;
    }

*/