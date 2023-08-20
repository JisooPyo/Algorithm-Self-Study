package programmers.test2304.test230427;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic126 {

	public static void main(String[] args) {
		Basic126 b = new Basic126();

		int[] x = { 1, 2, 3, 4, 5, 6 };
		int[] y = { 58, 172, 746, 89 };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public int[] solution(int[] arr) {
		int square = 0;

		for (int i = 0; i <= 10; i++) {
			if (arr.length <= Math.pow(2, i)) {
				square = i;
				break;
			}
		}

		int length = (int) Math.pow(2, square);
		int add = length - arr.length;

		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

		for (int i = 1; i <= add; i++) {
			list.add(0);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

    public int[] solution(int[] arr) {

        int len = arr.length;
        int tmp = 1;

        while (tmp < len) {
            tmp *= 2;
        }

        int[] answer = new int[tmp];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }

*/