package programmers.test2304.test230412;

public class FindDotPositionProblem {

	public static void main(String[] args) {
		
		FindDotPositionProblem fd = new FindDotPositionProblem();
		
		int[] a = {2,4};
		int[] b = {-7,9};
		
		System.out.println(fd.solution(a));
		System.out.println(fd.solution(b));

	}

	public int solution(int[] dot) {
		int answer = 0;
		if(dot[0]>0) {
			answer = (dot[1]>0)? 1 : 4;
		} else {
			answer = (dot[1]>0)? 2 : 3;
		}
		return answer;
	}

}
