package programmers.test2304.test230427;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Basic129 {

	public static void main(String[] args) {
		Basic129 b = new Basic129();

		int[] x = { 0, 1, 1, 2, 2, 3 };
		int[] y = { 0, 1, 1, 1, 1 };

		System.out.println(Arrays.toString(b.solution(x, 3)));
		System.out.println(Arrays.toString(b.solution(y, 4)));

	}

	public int[] solution(int[] arr, int k) {
		Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		// arr을 Integer 배열로 변환
		LinkedHashSet<Integer> hash = new LinkedHashSet<Integer>(Arrays.asList(arr2));
		// arr2를 LinkedHashSet hash로 변환
		Integer[] arr3 = hash.toArray(new Integer[0]);
		// LinkedHashSet hash를 Integer 배열 arr3로 변환
		int[] arr4 = Arrays.stream(arr3).mapToInt(i -> i).toArray();
		// Integer 배열 arr3을 int 배열 arr4로 변환
		int[] answer = new int[k];
		if (arr4.length < k) {
			for (int i = 0; i < arr4.length; i++) {
				answer[i] = arr4[i];
			}
			for (int i = arr4.length; i < k; i++) {
				answer[i] = -1;
			}
		} else {
			for (int i = 0; i < k; i++) {
				answer[i] = arr4[i];
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int k) {
        return IntStream.concat(Arrays.stream(arr).distinct(), IntStream.range(0, k).map(i -> -1))
        						// Arrays.stream(arr).distinct()와 IntStream.range(0,k).map(i->-1)를 합쳐주세요.
        		
        		* Arrays.stream(arr).distinct()
        		  arr을 stream으로 변환한 뒤, 중복되는 요소들을 모두 제거해주고 새로운 스트림으로 리턴.
        		* IntStream.range(0,k).map(i->-1)
        		  0에서 k-1까지의 수를 뽑아와서 그 수 만큼 -1을 넣은 IntStream.
        		         		 
        		.limit(k)
        	 	// .limit(num)는 stream에서 num만큼만 데이터를 가져와서 새로운 스트림을 생성하고 리턴.
        	 	 
        	 	 
        		.toArray();
        		// 이제까지의 stream을 배열로 바꿔서.
    }
}


*/