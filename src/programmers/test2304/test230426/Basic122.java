package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic122 {

	public static void main(String[] args) {
		Basic122 b = new Basic122();

		int[] arr = { 3, 2, 4, 1, 3 };
		boolean[] flag = { true, false, true, false, false };

		System.out.println(Arrays.toString(b.solution(arr, flag)));

	}

	public int[] solution(int[] arr, boolean[] flag) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < flag.length; i++) {
			if (flag[i]) {
				for (int j = 1; j <= arr[i] * 2; j++) {
					list.add(arr[i]);
				}
			} else {
				for (int k = 1; k <= arr[i]; k++) {
					list.remove(list.size() - 1);
				}
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

String, valueOf, repeat, substring, Stream.of, mapToInt 사용!

import java.util.stream.Stream;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        String answer = "";

        for(int idx=0; idx<arr.length; idx++) {
        
            if(flag[idx]) {
                answer += String.valueOf(arr[idx]).repeat(arr[idx]*2);
            }
            else {
                answer = answer.substring(0, answer.length() - arr[idx]);
            }
            
        }

        return Stream.of(answer.split("")).mapToInt(Integer::parseInt).toArray();
    }
}

*/