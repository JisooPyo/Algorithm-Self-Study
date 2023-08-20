package programmers.test2304.test230420;

public class Basic030 {

	public static void main(String[] args) {
		
		Basic030 b = new Basic030();
		
		System.out.println(b.solution("abc", "aabcc"));
		System.out.println(b.solution("tbt", "tbbttb"));

	}
	

    public int solution(String str1, String str2) {
        if(str2.contains(str1)) {
        	return 1;
        } else {
        	return 0;
        }
    }

}
