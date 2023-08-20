package programmers.test2304.test230423;

public class Basic078 {

	public static void main(String[] args) {
		Basic078 b = new Basic078();

		System.out.println(b.solution(29183, 1));
		System.out.println(b.solution(232443, 4));
		System.out.println(b.solution(123456, 7));

	}

	public int solution(int num, int k) {
		int count = 0;
		int place = 0;

		while (num > 0) {
			place++;
			if (num % 10 == k) {
				count = place;
			}
			num = num / 10;
		}
		return count == 0 ? -1 : place - count + 1;
	}

}
/*

다른 사람의 풀이

num 앞에 "-"를 붙임으로써 index를 0이 아닌 1부터 세게 한다.
indexOf 메소드는 index를 찾지 못하면 -1을 출력한다.

    public int solution(int num, int k) {
        return ("-" + num).indexOf(String.valueOf(k));
    }

*/
