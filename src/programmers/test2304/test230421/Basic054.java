package programmers.test2304.test230421;

public class Basic054 {

	public static void main(String[] args) {

		Basic054 b = new Basic054();

		String[] x1 = { "abc", "def", "ghi" };
		String x2 = "ef";
		
		String[] y1 = { "abc", "bbc", "cbc" };
		String y2 = "c";

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));
		System.out.println("end");

	}

	public String solution(String[] str_list, String ex) {
		String answer = "";
		for (int i = 0; i < str_list.length; i++) {
			if(!str_list[i].contains(ex)) {
				answer+=str_list[i];
			}
		}
		return answer;
	}

}

/*

 for(int i=0; i<str_list.length; i++) {
            if(str_list[i].contains(ex)) continue;

            answer += str_list[i];
        }

*/