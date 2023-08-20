package programmers.test2304.test230421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic058 {

	public static void main(String[] args) {
		Basic058 b = new Basic058();

		int[] x = { 5, 1, 4 };
		int[] y = { 6, 6 };
		int[] z = { 1 };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));
		System.out.println(Arrays.toString(b.solution(z)));

	}

	public int[] solution(int[] arr) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= arr[i]; j++) {
				ans.add(arr[i]);
			}
		}
		int[] answer = ans.stream().mapToInt(i -> i).toArray();
		return answer;
	}

}

// 리스트 -> int 배열
// https://velog.io/@deannn/Java-int%ED%98%95-ArrayList-%EB%B0%B0%EC%97%B4-%EB%B3%80%ED%99%98

/*

다른 사람의 풀이

    public int[] solution(int[] arr) {
        int[] answer = new int[Arrays.stream(arr).sum()];

        int index = 0;
        for(int item : arr) {
            for(int i = 0; i < item; i++) {
                answer[index++] = item;
            }
        }

        return answer;
    }


*/