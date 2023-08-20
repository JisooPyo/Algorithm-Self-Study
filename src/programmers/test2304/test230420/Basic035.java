package programmers.test2304.test230420;

import java.util.ArrayList;
import java.util.Arrays;

public class Basic035 {

	public static void main(String[] args) {

		Basic035 b = new Basic035();

		int[] x = { 1, 4, 2, 5, 3 };

		System.out.println(Arrays.toString(b.solution(x)));

	}

	public int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();

		int i = 0;

		while (i < arr.length) {
			if (list.size() == 0) {
				list.add(arr[i]);
				i++;
			} else {
				if (list.get(list.size() - 1) < arr[i]) {
					list.add(arr[i]);
					i++;
				} else {
					list.remove(list.size() - 1);
				}
			}
		}
		
		int[] stk = list.stream().mapToInt(j -> j).toArray();
		
		return stk;
	}

}

/*

stack 클래스의 pop, isEmpty, push, peek 메소드 사용

import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack();
        for(int i : arr ){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && i <= stack.peek()) {
                stack.pop();
            }
            stack.push(i);
        }
        int[] answer = new int[stack.size()];
        for(int i=0; i<answer.length; i++) {
            answer[answer.length - 1 - i] = stack.pop();
        }
        return answer;
    }
}

*/
