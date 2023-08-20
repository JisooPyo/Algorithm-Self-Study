/*

문제 설명

선분 3개가 평행하게 놓여 있습니다.
세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.

제한사항

lines의 길이 = 3
lines의 원소의 길이 = 2
모든 선분은 길이가 1 이상입니다.
lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
-100 ≤ a < b ≤ 100

 */
package programmers.test2304.test230429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lev0_11 {

	public static void main(String[] args) {
		Lev0_11 lev = new Lev0_11();

		int[][] t1 = { { 0, 1 }, { 2, 5 }, { 3, 9 } };
		int[][] t2 = { { -1, 1 }, { 1, 3 }, { 3, 9 } };
		int[][] t3 = { { 0, 5 }, { 3, 9 }, { 1, 10 } };
		int[][] t4 = { { 0, 2 }, { -3, -1 }, { -2, 1 } };
		int[][] t5 = { { -3, -1 }, { -2, 3 }, { 2, 3 } };
		int[][] t6 = { { 0, 3 }, { -3, -1 }, { -2, 3 } };

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));
		System.out.println(lev.solution(t3));
		System.out.println(lev.solution(t4));
		System.out.println(lev.solution(t5));
		System.out.println(lev.solution(t6));

	}

	public int solution(int[][] lines) {
		// 두 라인끼리의 교집합 찾기.
		int[] over1 = intersection(lines[0], lines[1]);
		int[] over2 = intersection(lines[1], lines[2]);
		int[] over3 = intersection(lines[2], lines[0]);
		int[] zero = { 0, 0 };
		// list<list> 선언 후 교집합이 제로이면 add하지 않는다.
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();

		if (!Arrays.equals(over1, zero)) {
			list.add(Arrays.stream(over1).boxed().collect(Collectors.toList()));
		}
		if (!Arrays.equals(over2, zero)) {
			list.add(Arrays.stream(over2).boxed().collect(Collectors.toList()));
		}
		if (!Arrays.equals(over3, zero)) {
			list.add(Arrays.stream(over3).boxed().collect(Collectors.toList()));
		}
		// list의 size가 0이면 교집합이 없다는 의미이므로 0 리턴.
		if (list.size() == 0) {
			return 0;
		}
		
		// list를 2차원 array로 변환
		int[][] arr = new int[list.size()][2];

		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i).stream().mapToInt(k -> k).toArray();
		}
		
		// 2차원 array 정렬
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		// arr 원소의 합집합의 길이 찾기
		if (arr.length == 3) {
			int start = arr[0][0];
			int end = Math.max(Math.max(arr[0][1], arr[1][1]), arr[2][1]);
			return end - start;
		} else if (arr.length == 2) {
			if (arr[0][1] <= arr[1][0]) {
				return (arr[1][1] - arr[1][0]) + (arr[0][1] - arr[0][0]);
			} else {
				return arr[1][1] - arr[0][0];
			}
		} else { // arr.length==1
			return arr[0][1] - arr[0][0];
		}
	}

	public int[] intersection(int[] x, int[] y) {
		int[] len = new int[2];
		if (x[0] <= y[0]) {
			if (x[1] <= y[0]) {
				return len;
			} else {
				if (y[1] <= x[1]) {
					len = y;
				} else {
					len[0] = y[0];
					len[1] = x[1];
				}
			}
		} else {
			if (y[1] <= x[0]) {
				return len;
			} else {
				if (x[1] <= y[1]) {
					len = x;
				} else {
					len[0] = x[0];
					len[1] = y[1];
				}
			}
		}

		return len;
	}
}
