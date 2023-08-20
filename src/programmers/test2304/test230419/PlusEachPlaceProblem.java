package programmers.test2304.test230419;

public class PlusEachPlaceProblem {

	public static void main(String[] args) {
		
		PlusEachPlaceProblem pep = new PlusEachPlaceProblem();
		
		System.out.println(pep.solution(1234));
		System.out.println(pep.solution(930211));

	}
	
    public int solution(int n) {
        int answer = 0;
        while(n>0) {
        	answer = answer + n%10;
        	n=n/10;
        }
        return answer;
    }

}

// while 이용!