package programmers.test2304.test230427;

import java.util.Arrays;

public class Basic128 {

	public static void main(String[] args) {
		Basic128 b = new Basic128();

		int[] x = { 1, 2, 3, 100, 99, 98 };

		System.out.println(b.solution(x));

	}

	public int solution(int[] arr) {
		int answer = 0;
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 50 && (arr[i] % 2 == 0)) {
				arr2[i] = arr[i] / 2;
			} else if (arr[i] < 50 && (arr[i] % 2 == 1)) {
				arr2[i] = arr[i] * 2 + 1;
			}
		}

		if (Arrays.equals(arr, arr2)) {
			return 0;
		}

		while (!(Arrays.equals(arr, arr2))) {
			arr = Arrays.copyOf(arr2, arr2.length);
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= 50 && (arr[i] % 2 == 0)) {
					arr2[i] = arr[i] / 2;
				} else if (arr[i] < 50 && (arr[i] % 2 == 1)) {
					arr2[i] = arr[i] * 2 + 1;
				}
			}
			answer++;
		}

		return answer;
	}

}
/*

import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        return Arrays.stream(arr).map(i -> cntAction(i)).max().getAsInt();
    }

    private int cntAction(int n) {

        int cnt = 0;
        boolean flag = true;

        while (flag) {

            if (n % 2 == 0 && 50 <= n) {
                n /= 2;
                cnt++;
            } else if (n % 2 == 1 && n < 50) {
                n *= 2;
                n += 1;
                cnt++;
            } else {
                flag = false;
            }
        }
        return cnt;
    }
}

*/
