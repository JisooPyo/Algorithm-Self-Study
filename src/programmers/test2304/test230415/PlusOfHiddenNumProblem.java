package programmers.test2304.test230415;

public class PlusOfHiddenNumProblem {

	public static void main(String[] args) {

		PlusOfHiddenNumProblem p = new PlusOfHiddenNumProblem();

		String x = "aAb1B2cC34oOp";

		String y = "1a2b3c4d123";

		System.out.println(p.solution(x));
		System.out.println(p.solution(y));

	}

	public int solution(String my_string) {

		int answer = 0;

		String string2 = my_string.replaceAll("[^0-9]", "");

		char[] arr = string2.toCharArray();
		int[] arr2 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Character.getNumericValue(arr[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			answer = answer + arr2[i];
		}

		return answer;

	}

}


// Character.getNumericValue
// .replaceAll("[^0-9]", "")