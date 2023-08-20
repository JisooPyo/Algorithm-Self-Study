package programmers.test2304.test230427;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic133 {

	public static void main(String[] args) {
		Basic133 b = new Basic133();

		int[] x = { 0, 1, 1, 1, 0 };
		int[] y = { 0, 1, 0, 1, 0 };
		int[] z = { 0, 1, 1, 0 };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));
		System.out.println(Arrays.toString(b.solution(z)));

	}

	public int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (list.size() == 0) {
				list.add(arr[i]);
			} else {
				if (list.get(list.size() - 1) == arr[i]) {
					list.remove(list.size() - 1);
				} else {
					list.add(arr[i]);
				}
			}
		}

		int[] answer = list.stream().mapToInt(i -> i).toArray();
		return answer.length == 0 ? new int[] { -1 } : answer;
	}

}

/*

다른 사람의 풀이

import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int no : arr) {
            if (!stack.isEmpty() && no == stack.peek()) {
                stack.pop();
            } else {
                stack.push(no);
            }
        }

        return stack.isEmpty() ? new int[] { -1 } : stack.stream().mapToInt(i -> i).toArray();
    }
}

*/