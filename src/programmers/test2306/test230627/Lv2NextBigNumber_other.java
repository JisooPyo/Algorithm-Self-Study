package programmers.test2306.test230627;

public class Lv2NextBigNumber_other {
	public static void main(String[] args) {
		Lv2NextBigNumber_other lv = new Lv2NextBigNumber_other();

		System.out.println(lv.solution(78));
		System.out.println(lv.solution(15));
		System.out.println(lv.solution(16));
		System.out.println(lv.solution(17));
		System.out.println(lv.solution(18));
		System.out.println(lv.solution(19));
		System.out.println(lv.solution(20));
		System.out.println(lv.solution(21));
		System.out.println(lv.solution(22));
		System.out.println(lv.solution(23));

	}

	public int solution(int n) {
		System.out.println("------------------------------------------------");
		System.out.println("n : " + Integer.toBinaryString(n));
		System.out.println("-n : " + Integer.toBinaryString(-n));
		int postPattern = n & -n;
		System.out.println("postPattern : " + Integer.toBinaryString(postPattern));
		int a = n + postPattern;
		System.out.println("n + postPattern : " + Integer.toBinaryString(a));
		int b = n ^ a;
		System.out.println("n ^ (n + postPattern) : " + Integer.toBinaryString(b));
		int c = b / postPattern;
		System.out.println("(n ^ (n + postPattern)) / postPattern : " + Integer.toBinaryString(c));
		int smallPattern = c >> 2;
		System.out.println("((n ^ (n + postPattern)) / postPattern) >> 2 : " + Integer.toBinaryString(smallPattern));
		int d = a | smallPattern;
		System.out.println("n + postPattern | smallPattern : " + Integer.toBinaryString(d));
		return n + postPattern | smallPattern;
	}
}

/*
정확성  테스트
테스트 1 〉통과 (0.02ms, 77.9MB)
테스트 2 〉통과 (0.02ms, 70.9MB)
테스트 3 〉통과 (0.02ms, 80.2MB)
테스트 4 〉통과 (0.02ms, 74.7MB)
테스트 5 〉통과 (0.03ms, 86MB)
테스트 6 〉통과 (0.02ms, 76.8MB)
테스트 7 〉통과 (0.03ms, 66MB)
테스트 8 〉통과 (0.02ms, 71.1MB)
테스트 9 〉통과 (0.02ms, 74MB)
테스트 10 〉통과 (0.03ms, 67.3MB)
테스트 11 〉통과 (0.03ms, 76.5MB)
테스트 12 〉통과 (0.03ms, 75.8MB)
테스트 13 〉통과 (0.02ms, 72.9MB)
테스트 14 〉통과 (0.03ms, 66.4MB)

효율성  테스트
테스트 1 〉통과 (0.02ms, 52.2MB)
테스트 2 〉통과 (0.02ms, 52.3MB)
테스트 3 〉통과 (0.02ms, 52.4MB)
테스트 4 〉통과 (0.02ms, 52.6MB)
테스트 5 〉통과 (0.02ms, 58.6MB)
테스트 6 〉통과 (0.02ms, 52.1MB)
 */