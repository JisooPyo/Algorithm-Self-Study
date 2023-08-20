package programmers.test2304.test230420;

public class Basic002 {

	public static void main(String[] args) {

		Basic002 b = new Basic002();

		System.out.println(b.solution(2, 91));
		System.out.println(b.solution(91, 2));
		StringBuilder s = new StringBuilder();
		s.append(2);
		s.append(2);
		System.out.println(s.toString());

	}

	public int solution(int a, int b) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.append(b);
		int merge = Integer.parseInt(sb.toString());
		int compare = 2*a*b;
		if(merge>compare) {
			answer = merge;
		} else {
			answer = compare;
		}
		
		return answer;
	}

}

/*

다른 사람의 풀이.

    public int solution(int a, int b) {
        int ab = Integer.parseInt(a + "" + b);
        if(2 * a * b <= ab) {
            return ab;
        } else {
            return 2 * a * b;
        }
    }

*/
