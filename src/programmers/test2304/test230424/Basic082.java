package programmers.test2304.test230424;

import java.util.Arrays;

public class Basic082 {

	public static void main(String[] args) {
		Basic082 basic = new Basic082();
		
		System.out.println(basic.solution("olleh", "hello"));
		System.out.println(basic.solution("allpe", "apple"));
		
	}
	
    public int solution(String before, String after) {
        int answer = 0;
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        Arrays.sort(b);
        Arrays.sort(a);
        if(Arrays.equals(a, b)) {
        	answer = 1;
        }
        
        return answer;
    }

}

/*

새로 알게 된 메소드
Arrays.equals(arr1,arr2) : arr1의 값과 arr2의 값을 비교하여 같은지 boolean 형태로 출력

다른 사람의 풀이

  return new String(a).equals(new String(b)) ? 1 :0;

*/
