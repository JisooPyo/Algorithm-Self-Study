package programmers.test2304.test230419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisorProblem {

	public static void main(String[] args) {

		DivisorProblem d = new DivisorProblem();

		int x = 24;
		int y = 29;

		System.out.println(Arrays.toString(d.solution(x)));
		System.out.println(Arrays.toString(d.solution(y)));

	}

	public int[] solution(int n) {

		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				ans.add(i);
			}
		}

		Integer arr[] = ans.toArray(new Integer[ans.size()]);
		int[] answer = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}

		return answer;
	}

}

/*
 * 
 * 다른 사람의 풀이 list.stream().mapToInt(x -> x).toArray() 를 이용해 list를 array로 바꿔 리턴.
 * 
 * public int[] solution(int n) { List<Integer> answer = new ArrayList<>();
 * for(int i=1; i<=n; i++){ if(n % i == 0){ answer.add(i); } } return
 * answer.stream().mapToInt(x -> x).toArray(); }
 * 
 */