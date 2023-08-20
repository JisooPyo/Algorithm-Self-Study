package programmers.test2304.test230415;

public class RidOfVowelsProblem {

	public static void main(String[] args) {

		RidOfVowelsProblem rov = new RidOfVowelsProblem();

		String x = "bus";
		String y = "nice to meet you";

		System.out.println(rov.solution(x));
		System.out.println(rov.solution(y));

	}

	public String solution(String my_string) {

		String answer = my_string.replaceAll("[aeiou]", "");
		return answer;

	}

}


// replaceAll