// 서울에서 김서방 찾기

package programmers.test2305.test230504;

public class Lev1_015 {

	public static void main(String[] args) {
		Lev1_015 lev = new Lev1_015();

		String[] t1 = { "Jane", "Kim" };

		System.out.println(lev.solution(t1));

	}

	public String solution(String[] seoul) {
		int index = 0;
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				index = i;
				break;
			}
		}
		String answer = "김서방은 " + index + "에 있다";
		return answer;
	}

}

/*

다른 사람의 풀이

리턴 값을 StringBuilder를 사용해서 하면 훨씬 빠른 속도로 결과를 도출할 수 있다!
return new StringBuilder("김서방은 ").append(x).append("에 있다");

-------------------------------------------------------------

list의 indexOf 메소드를 사용. 하지만 for문보다 느리다는 말이 있다..!

int x = Arrays.asList(seoul).indexOf("Kim");

 */
