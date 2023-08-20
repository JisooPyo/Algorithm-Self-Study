package programmers.test2304.test230413;

import java.util.Arrays;
import java.util.Collections;

public class OrderEmergencyProblem {

	public static void main(String[] args) {

		OrderEmergencyProblem oe = new OrderEmergencyProblem();

		int[] a = { 3, 76, 24 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7 };
		int[] c = { 30, 10, 23, 6, 100 };
		
		Integer[] arr1 = new Integer[a.length];

		for (int i = 0; i < a.length; i++) {
			arr1[i] = a[i];
		}

		Arrays.sort(arr1, Collections.reverseOrder());
		int[] arr2 = Arrays.stream(arr1).mapToInt(i -> i).toArray();

		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(oe.solution(a)));
		System.out.println(Arrays.toString(oe.solution(b)));
		System.out.println(Arrays.toString(oe.solution(c)));

	}

	public int[] solution(int[] emergency) {

		int l = emergency.length;

		int[] answer = new int[l];
		Integer[] arr1 = new Integer[l];

		for (int i = 0; i < l; i++) {
			arr1[i] = emergency[i];
		}

		Arrays.sort(arr1, Collections.reverseOrder());
		int[] arr2 = Arrays.stream(arr1).mapToInt(i -> i).toArray();

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (emergency[i] == arr2[j]) {
					answer[i] = j + 1;
					break;
				}

			}
		}

		return answer;

	}

}

/*
  
 answer.clone(); >> answer 객체를 참조하지 않고 새로운 배열 생성
 
 ---------------------------------------------------
 다른 사람의 풀이
 
     public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for(int i = 0; i < answer.length; i++){
            if(answer[i] != 0){
                continue;
            }
            int idx = 1;
            for(int j = 0; j < answer.length; j++){
                if(emergency[i] < emergency[j]){
                    idx++;
                }
            }
            answer[i] = idx;
        }
        return answer;
    }
 * 
 */
