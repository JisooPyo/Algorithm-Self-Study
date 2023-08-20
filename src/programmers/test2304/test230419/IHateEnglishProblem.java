package programmers.test2304.test230419;

public class IHateEnglishProblem {

	public static void main(String[] args) {

		IHateEnglishProblem ihe = new IHateEnglishProblem();
		String x = "onetwothreefourfivesixseveneightnine";
		String y = "onefourzerosixseven";
		System.out.println(ihe.solution(x));
		System.out.println(ihe.solution(y));

	}

	public long solution(String numbers) {
		String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String ans = "";
		long answer = 0;

		while (numbers.length() > 0) {
			Loop1: for (int i = 3; i <= 5; i++) {
				for (int j = 0; j < 10; j++) {
					if (numbers.substring(0, i).equals(num[j])) {
						ans += j;
						numbers = numbers.substring(i, numbers.length());
						break Loop1;
					}
				}
			}
		}
		answer = Long.parseLong(ans);
		return answer;
	}

}

/*

String.substring(0,3) : String의 0번째 index부터 2번째 index까지.
중첩 반복문에서는 반복문에 라벨을 지정해 주고 해당 라벨명을 break 명령에 기재하여 원하는 반복문 단계를 바로 빠져 나올 수 있다.
Long.parseLong(String) : String을 Long타입으로 변환

다른 사람의 풀이

replaceAll 메소드 이용.

public long solution(String numbers) {

    String[] numbers_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    for (int i = 0; i < numbers_arr.length; i++) {
        numbers = numbers.replaceAll(numbers_arr[i], String.valueOf(i));
    }

    long answer = Long.parseLong(numbers);
    return answer;
}

*/