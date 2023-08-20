// 문자열 내림차순으로 배치하기

package programmers.test2305.test230506;

import java.util.Arrays;

public class Lev1_024 {

	public static void main(String[] args) {
		Lev1_024 lev = new Lev1_024();
		
		System.out.println(lev.solution("Zbcdefg"));

	}
	
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        String answer = new String(ch);
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer).reverse();        
        return sb.toString();
    }

}
