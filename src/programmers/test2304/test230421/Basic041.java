package programmers.test2304.test230421;

public class Basic041 {

	public static void main(String[] args) {
		Basic041 b = new Basic041();

		int[] x = { 1, 2, 3, 4, 5 };
		int[] y = { 15, 98, 23, 2, 15 };

		System.out.println(b.solution(x, 3));
		System.out.println(b.solution(y, 20));

	}

	public int solution(int[] num_list, int n) {
		int answer = 0;
		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] == n) {
				answer = 1;
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이(stream 이용)

    public int solution(int[] numList, int n) {
        return IntStream.of(numList).anyMatch(num -> num == n) ? 1 : 0;
    }

*/