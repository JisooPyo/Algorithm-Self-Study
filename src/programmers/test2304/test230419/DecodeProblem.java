package programmers.test2304.test230419;

public class DecodeProblem {

	public static void main(String[] args) {

		DecodeProblem d = new DecodeProblem();

		String x1 = "dfjardstddetckdaccccdegk";
		int x2 = 4;
		String y1 = "pfqallllabwaoclk";
		int y2 = 2;

		System.out.println(d.solution(x1, x2));
		System.out.println(d.solution(y1, y2));

	}

	public String solution(String cipher, int code) {
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < cipher.length(); i++) {
			if (i % code == code - 1) {
				answer.append(cipher.charAt(i));
			}
		}
		return answer.toString();
	}

}

/*

charAt 활용, StringBuilder, append 활용

다른 사람의 풀이

1. 
i를 0부터 안 돌려도 된다..!!
substring 활용

    public String solution(String cipher, int code) {
        String answer = "";
        for(int i=code-1; i<cipher.length(); i+=code){
            answer += cipher.substring(i, i+1);
        }
        return answer;
    }

*/