package programmers.test2304.test230410;

public class CompareHeightProblem {

	public int solution(int[] array, int height) {
		int answer = 0;
		for (int i=0 ; i<array.length ; i++) {
			if(array[i]>height) {
				answer=answer+1;
			}
		}
		return answer;
	}

//	public static void main(String[] args) {
//		
//		int[] arr = {1, 26, 17, 25};
//		Arrays.sort(arr);
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		
//
//	}

}
