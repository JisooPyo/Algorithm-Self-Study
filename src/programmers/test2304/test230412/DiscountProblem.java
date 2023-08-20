package programmers.test2304.test230412;

public class DiscountProblem {

	public static void main(String[] args) {
		DiscountProblem dp = new DiscountProblem();
		
		System.out.println(dp.solution(150000));
		System.out.println(dp.solution(580000));

	}
	
	 public int solution(int price) {
	        int answer = 0;
	        if (price >= 500000) {
	        	answer = (int)(price * 0.8);
	        } else if (price >=300000) {
	        	answer = (int)(price * 0.9);
	        } else if (price >=100000) {
	        	answer = (int)(price * 0.95);
	        } else {
	        	answer = price;
	        }
	        return answer;
	    }

}

// 기본형 타입변환, else if