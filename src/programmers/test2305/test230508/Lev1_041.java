// 숫자 문자열과 영단어

package programmers.test2305.test230508;

public class Lev1_041 {

	public static void main(String[] args) {
		Lev1_041 lev = new Lev1_041();

		String t1 = "one4seveneight";
		String t2 = "23four5six7";
		String t3 = "2three45sixseven";
		String t4 = "123";

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));
		System.out.println(lev.solution(t3));
		System.out.println(lev.solution(t4));

	}

	public int solution(String s) {
		s = s.replaceAll("zero", "0");
		s = s.replaceAll("one", "1");
		s = s.replaceAll("two", "2");
		s = s.replaceAll("three", "3");
		s = s.replaceAll("four", "4");
		s = s.replaceAll("five", "5");
		s = s.replaceAll("six", "6");
		s = s.replaceAll("seven", "7");
		s = s.replaceAll("eight", "8");
		s = s.replaceAll("nine", "9");
		return Integer.parseInt(s);
	}

}

/*

다른 사람의 풀이

단어를 배열로 만들어 반복문으로!

    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
*/