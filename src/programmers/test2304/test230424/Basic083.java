package programmers.test2304.test230424;

public class Basic083 {

	public static void main(String[] args) {
		Basic083 b = new Basic083();

		System.out.println(b.solution(1, 13, 1));
		System.out.println(b.solution(10, 50, 5));
		System.out.println(b.solution(3, 10, 2));

	}

	public int solution(int i, int j, int k) {
		int answer = 0;
		for (int p = i; p <= j; p++) {
			int num = p;
			while (num > 0) {
				if (num % 10 == k) {
					answer += 1;
				}
				num = num / 10;
			}
		}
		return answer;
	}

}

/*

알게 된 것!! for문은 i에서 j까지 하나씩 올리면서 p에 대입되는 게 아니라
i에서 시작하여 ++을 계속 해주는데 그게 j가 될때까지 하는 것!!!
따로 int num = p 를 넣어주지 않으면 무한루프에 빠지게 됨..!

다른 사람의 풀이

    public int solution(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }

*/
