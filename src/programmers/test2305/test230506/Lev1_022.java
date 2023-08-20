// 수박수박수박수?
package programmers.test2305.test230506;

public class Lev1_022 {

	public static void main(String[] args) {
		Lev1_022 lev = new Lev1_022();

		System.out.println(lev.solution(3));
		System.out.println(lev.solution(4));

	}

	public String solution(int n) {
		String answer = "";
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				answer += "수";
			} else {
				answer += "박";
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

    public String watermelon(int n){

        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }

*/