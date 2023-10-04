package programmers.test2310;

public class NLCMs {
	public static void main(String[] args) {
		NLCMs nlcMs = new NLCMs();

		int[] arr1 = {2, 6, 8, 14};
		int[] arr2 = {1, 2, 3};

		System.out.println(nlcMs.solution(arr1));
		System.out.println(nlcMs.solution(arr2));

	}

	public int solution(int[] arr) {
		int answer = arr[0];
		for (int i = 1; i < arr.length; i++) {
			answer = answer * arr[i] / gcd(answer, arr[i]);
		}
		return answer;
	}

	public int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		} else if (a == b) {
			return a;
		}
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}

/*
테스트 1 〉통과 (0.02ms, 74.8MB)
테스트 2 〉통과 (0.02ms, 71.9MB)
테스트 3 〉통과 (0.02ms, 68.7MB)
테스트 4 〉통과 (0.02ms, 66.2MB)
테스트 5 〉통과 (0.03ms, 72.2MB)
테스트 6 〉통과 (0.02ms, 77.6MB)
테스트 7 〉통과 (0.02ms, 74.8MB)
테스트 8 〉통과 (0.02ms, 72MB)
테스트 9 〉통과 (0.02ms, 78.1MB)
테스트 10 〉통과 (0.04ms, 78.1MB)
 */