package programmers.test2304.test230414;

public class RockScissorPaperProblem {

	public static void main(String[] args) {

		RockScissorPaperProblem rsp = new RockScissorPaperProblem();

		String x1 = "2";
		String x2 = "205";

		System.out.println(rsp.solution(x1));
		System.out.println(rsp.solution(x2));

	}

	public String solution(String rsp) {

		String answer = "";

		char[] array = rsp.toCharArray(); // {2,0,5}

		for (int i = 0; i < array.length; i++) {
			
			if(array[i]=='2') {
				array[i]='0';
			} else if(array[i]=='0') {
				array[i]='5';
			} else {
				array[i]='2';
			}

		}	// {0,5,2}
		
		answer = new String(array);	// answer = "052"

		return answer;

	}

}

/*

다른 사람의 풀이 StringBuilder, append메소드, toCharArray메소드,for문,switch문 사용.

    public String solution(String rsp) {
        char[] cRsp = rsp.toCharArray();
        StringBuilder answer = new StringBuilder();

        for(int i=0; i < cRsp.length; i++) {
            switch(cRsp[i]) {
                case '0' :
                    answer.append("5");
                    break;
                case '2' :
                    answer.append("0");
                    break;
                case '5' :
                    answer.append("2");
                    break;
            }
        }
        return answer.toString();

    }

*/
