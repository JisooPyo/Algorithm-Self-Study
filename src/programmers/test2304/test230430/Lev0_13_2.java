package programmers.test2304.test230430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lev0_13_2 {

	public static void main(String[] args) {
		Lev0_13_2 lev = new Lev0_13_2();

		int[] t1 = { 1, 2, 3, 4, 5, 6 };
		int[] t2 = { 10000, 20, 36, 47, 40, 6, 10, 7000 };

		System.out.println(Arrays.toString(lev.solution(t1, 4)));
		System.out.println(Arrays.toString(lev.solution(t2, 30)));

	}

	public int[] solution(int[] numlist, int n) {
		Integer[] conv = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
		Arrays.sort(conv, Collections.reverseOrder());
		numlist = Arrays.stream(conv).mapToInt(Integer::intValue).toArray();

		int[] diff = new int[numlist.length];
		for (int i = 0; i < numlist.length; i++) {
			diff[i] = Math.abs(numlist[i] - n);
		}
		int diffMax = Arrays.stream(diff).max().getAsInt();

		List<Integer> list = new ArrayList<>();
		for (int j = 0; j <= diffMax; j++) {
			for (int i = 0; i < numlist.length; i++) {
				if (Math.abs(numlist[i] - n) == j) {
					list.add(numlist[i]);
				}
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

import java.util.Arrays;

class Solution {
    public int[] solution(int[] numList, int n) {
        return Arrays.stream(numList)
        			// numList(Array) -> IntStream
                .boxed()
                	// IntStream -> Stream<Integer>
                .sorted((a, b) 
                	-> Math.abs(a - n)
                		== Math.abs(b - n) ?
                			b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                	//sorted() : 객체의 Comparable 구현 방법에 따라 정렬
                	 * sorted(Comparator<T>) : 객체를 주어진 Comparator에 따라 정렬 
                	 * 아래 설명 참고
                	 * 
                	 * Comparable, Comparator에 대한 설명
                	 * https://st-lab.tistory.com/243
                	 
                .mapToInt(Integer::intValue)
                
                .toArray();
    }
}

----------------------------------------------------------------------------------------------

if (Math.abs(a - n) == Math.abs(b - n)) {       // n으로부터의 거리가 같다면
	b.compareTo(a);										  // 더 큰 수를 앞에 오도록
} else {
	 Integer.compare(Math.abs(a - n), Math.abs(b-n)));    	// n과 가까운 수부터 정렬
}

----------------------------------------------------------------------------------------------

b.compareTo(a)에서는 큰수부터 정렬하는 역순으로 정렬해야 해서 a, b자리를 바꾸고
Integer.compare에서는 abs가 작은 거부터 정렬하는 정순으로 정렬해야 해서 a, b자리를 그대로..

----------------------------------------------------------------------------------------------

return int로 정렬하는 언어는 대부분 다 C에서 영향을 받았다고 봐도 무방합니다.

이를 이해하기 위해서는 정렬을 2차원 선분 위에서 점을 옮긴다고 생각하시면 좋습니다.

0에서 끝까지 가면서 각 단계별로 첫번째 인자를 a, 두번째 인자를 b로 봅니다.

여기서 1과 -1은 a를 어느쪽 방향으로 보낼지를 결정합니다.

그러니 if (a > b ) return 1; 이라는 코드는 a가 더 클 때 뒤로 보내니 더 작은 게 앞쪽에, 더 큰 게 뒤쪽에 위치하게 되고 결국 오름차순이 됩니다.

*/