package programmers.test2304.test230419;

public class ThreeSixNineProblem {

	public static void main(String[] args) {

		ThreeSixNineProblem tsn = new ThreeSixNineProblem();

		int x = 3;
		int y = 29423;

		System.out.println(tsn.solution(x));
		System.out.println(tsn.solution(y));

	}

	public int solution(int order) {
		int answer = 0;
		String order2 = Integer.toString(order); // order2 = "29423"
		String[] ordersplit = order2.split(""); // ordersplit = {"2","9","4","2","3"}
		for (int i = 0; i < ordersplit.length; i++) {
			if(ordersplit[i].equals("3")||ordersplit[i].equals("6")||ordersplit[i].equals("9")) {
				answer++;
			}
		}

		return answer;

	}

}

/*

String.split 사용.
String 비교시에는 equals

*/
