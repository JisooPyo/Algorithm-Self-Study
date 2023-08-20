package programmers.test2304.test230419;

public class ChangeIndexProblem {

	public static void main(String[] args) {
		
		ChangeIndexProblem ci = new ChangeIndexProblem();
		
		String x1 = "Hello";
		int x2 = 1;	//"l"
		int x3 = 2;	//"e"
		
		String y1 = "I love you";
		int y2 = 3;
		int y3 = 6;
		
		System.out.println(ci.solution(x1, x2, x3));
		System.out.println(ci.solution(y1, y2, y3));

	}
	
    public String solution(String my_string, int num1, int num2) {
        StringBuilder ans = new StringBuilder();
        ans.append(my_string);
        ans.setCharAt(num1, my_string.charAt(num2));
        ans.setCharAt(num2, my_string.charAt(num1));
        return ans.toString();
    }

}

/*

StringBuilder.setCharAt(num1,char) :
StringBuilder에서 num1번째 인덱스에 있는 값을 char로 바꾼다.

*/
