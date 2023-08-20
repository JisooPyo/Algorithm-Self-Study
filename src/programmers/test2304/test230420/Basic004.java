package programmers.test2304.test230420;

public class Basic004 {

	public static void main(String[] args) {
		
		Basic004 b = new Basic004();
		
		String[] x = {"cafelatte", "americanoice", "hotcafelatte", "anything"};
		String[] y = {"americanoice", "americano", "iceamericano"};
		
		System.out.println(b.solution(x));
		System.out.println(b.solution(y));
		

	}

	public int solution(String[] order) {
		int la = 0;
		int ame = 0;
		for (int i = 0; i < order.length; i++) {
			if (order[i].contains("latte")) {
				la++;
			} else {
				ame++;
			}
		}
		int answer = ame * 4500 + la * 5000;
		return answer;
	}

}

/*

다른 사람의 for문

for(String o : order) {
            if(o.contains("cafelatte")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }

*/