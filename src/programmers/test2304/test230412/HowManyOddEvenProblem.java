package programmers.test2304.test230412;

import java.util.Arrays;

public class HowManyOddEvenProblem {

	public static void main(String[] args) {
		HowManyOddEvenProblem hm = new HowManyOddEvenProblem();
		
		int[] arr1 = new int[]{1,2,3,4,5};
		int[] arr2 = new int[]{1,3,5,7};
		int[] ans1 = hm.solution(arr1);
		int[] ans2 = hm.solution(arr2);
		System.out.println(Arrays.toString(ans1));
		System.out.println(Arrays.toString(ans2));
		
	}
	
    public int[] solution(int[] num_list) {
        int[] answer = new int[] {0,0};
        for(int i=0;i<num_list.length;i++) {
        	if(num_list[i]%2 == 0) {
        		answer[0]++;
        	} else {
        		answer[1]++;
        	}
        }
        return answer;
    }

}

/*

다른 사람의 풀이

    public int[] solution(int[] num_list) {
    
        int[] answer = new int[2];

        for(int i = 0; i < num_list.length; i++)
            answer[num_list[i] % 2]++;

        return answer;
    }

*/