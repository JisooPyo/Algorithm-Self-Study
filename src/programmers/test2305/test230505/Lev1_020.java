// 없는 숫자 더하기
package programmers.test2305.test230505;

public class Lev1_020 {

	public static void main(String[] args) {
		Lev1_020 lev = new Lev1_020();

		int[] t1 = { 1, 2, 3, 4, 6, 7, 8, 0 };
		int[] t2 = { 5, 8, 4, 0, 6, 7, 9 };

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));

	}

	public int solution(int[] numbers) {
		int answer = 0;
		for (int i = 1; i < 10; i++) {
			boolean contain = false;
			for (int j = 0; j < numbers.length; j++) {
				if (i == numbers[j]) {
					contain = true;
				}
			}
			if (!contain) {
				answer += i;
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이
1부터 9까지의 합에서 numbers의 원소를 for문을 이용해 빼면 되는 것이었다..!!!

    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }

*/