package programmers.test2304.test230425;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic103 {

	public static void main(String[] args) {

		Basic103 b = new Basic103();

		int[] x1 = { 293, 1000, 395, 678, 94 };
		int[] x2 = { 94, 777, 104, 1000, 1, 12 };

		int[] y1 = { 110, 66, 439, 785, 1 };
		int[] y2 = { 377, 823, 119, 43 };

		System.out.println(Arrays.toString(b.solution(x1, x2)));
		System.out.println(Arrays.toString(b.solution(y1, y2)));

	}

	public int[] solution(int[] arr, int[] delete_list) {
		List<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toList());
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < delete_list.length; j++) {
				if (arr[i] == delete_list[j]) {
					a.remove(Integer.valueOf(arr[i]));
				}
			}
		}
		return a.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

list에 arr의 값들을 모두 넣은 후 delete_list의 값들을 삭제함
for문을 이용해서 list와 같은 int배열을 만든 후 리턴

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for(int n : arr) {
            list.add(n);
        }
        for(int n: delete_list) {
            list.remove((Integer)n);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

*/