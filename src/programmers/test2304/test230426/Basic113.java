package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic113 {

	public static void main(String[] args) {
		Basic113 b = new Basic113();

		int[] x = { 1, 2, 1, 4, 5, 2, 9 };
		int[] y = { 1, 2, 1 };
		int[] z = { 1, 1, 1 };
		
		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));
		System.out.println(Arrays.toString(b.solution(z)));

	}

	public int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				list.add(i);
			}
		}
		if (list.size() == 0) {
			return new int[] { -1 };
		} else if (list.size() == 1) {
			return new int[] { 2 };
		} else {
			Integer firstIndex = list.get(0);
			Integer lastIndex = list.get(list.size() - 1);
			for (int i = firstIndex.intValue(); i <= lastIndex.intValue(); i++) {
				list2.add(arr[i]);
			}
			return list2.stream().mapToInt(i -> i).toArray();
		}
	}

}

/*

다른 사람의 풀이

import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
    
        int[] idx = IntStream
        		.range(0, arr.length)
        		.filter(i -> arr[i] == 2)
        		.toArray();
        
        if (idx.length == 0) return new int[]{-1};
        
        return IntStream
        		.rangeClosed(idx[0], idx[idx.length - 1])
        		.map(i -> arr[i])
        		.toArray();
        		
    }
}

*/
