// 약수의 합

package programmers.test2305.test230501;

public class Lev1_003 {

	public static void main(String[] args) {
		Lev1_003 lev = new Lev1_003();

		System.out.println(lev.solution(12));
		System.out.println(lev.solution(5));

	}

	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				answer += i;
			}
		}
		return answer;
	}

}

/*
 * 다른 사람의 풀이 : 절반만 돌면 되는 코드!
 * 
 * public int solution(int num) { int answer = 0; for(int i =1 ; i<=num/2;i++){
 * if(num%i==0){ answer+=i;}}
 * 
 * 
 * return answer+num; }
 * 
 */
