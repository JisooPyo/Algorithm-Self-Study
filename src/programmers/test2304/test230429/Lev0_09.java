package programmers.test2304.test230429;

import java.util.stream.IntStream;

/*
3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다.
3x 마을 사람들의 숫자는 다음과 같습니다.

10진법	3x 마을에서 쓰는 숫자
1		1	
2		2

3		4	
4		5	

5		7	
6		8

7		10
8		11

9		14

10		16

정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.
 
 */
public class Lev0_09 {

	public static void main(String[] args) {
		Lev0_09 lev = new Lev0_09();
		
		System.out.println(lev.solution(15));
		System.out.println(lev.solution(40));

	}
	
    public int solution(int n) {
        int[] x3 = IntStream.rangeClosed(0, 1000).filter(i -> i%3!=0 && !(Integer.toString(i).contains("3"))).toArray();
        return x3[n-1];
    }

}
/*

이번 풀이는 intstream을 이용해서 풀어 보았다..!! 감격! 그렇지만 더 쉽게 푸는 방법도 있었다!!

다른 사람의 풀이

class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }

        return answer;
    }
}

 */
