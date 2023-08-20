package programmers.test2304.test230420;

public class ReturnMaximumProblem {

	public static void main(String[] args) {

		ReturnMaximumProblem rm = new ReturnMaximumProblem();

		int[] x = { 1, 2, -3, 4, -5 };
		int[] y = { 0, -31, 24, 10, 1, 9 };
		int[] z = { 10, 20, 30, 5, 5, 20, 5 };

		System.out.println(rm.solution(x));
		System.out.println(rm.solution(y));
		System.out.println(rm.solution(z));

	}

	public int solution(int[] numbers) {
        int max = numbers[0]*numbers[1];
        for(int i=0;i<numbers.length;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		if(max<numbers[i]*numbers[j]) {
        			max = numbers[i]*numbers[j];
        		}
        	}
        }
        return max;
    }

}

/*

다른 사람의 풀이
sort를 사용!!

    public int solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
    }

*/
