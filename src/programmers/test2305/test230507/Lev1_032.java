package programmers.test2305.test230507;

import java.util.Arrays;

public class Lev1_032 {

	public static void main(String[] args) {
		Lev1_032 lev = new Lev1_032();

		String str = "  try hello world java    ";
		
		System.out.println(Arrays.toString(str.split("")));

		System.out.println("여기부터:"+lev.solution(str)+":여기까지");
	}

	public String solution(String s) {
		String[] sp = s.split(" "); // {try, " ", hello, " ", world}

		for (int i = 0; i < sp.length; i++) {
			char[] ch = sp[i].toCharArray(); // ch = { t, r, y }
			for (int j = 0; j < ch.length; j++) {
				if (j % 2 == 0) {
					ch[j] = Character.toUpperCase(ch[j]);
				} else {
					ch[j] = Character.toLowerCase(ch[j]);
				}
			}
			sp[i] = new String(ch);
		}

		int space_count = 0;
		String space = " ";
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.substring(i).equals(space)) {
				space_count++;
				space += " ";
			} else {
				break;
			}
		}

		return String.join(" ", sp) + " ".repeat(space_count);
	}

}

// 4, 5, 8, 9, 11 틀림
// 뒤에 공백이 있으면 결과가 달라지기 때문에
// 공백의 수를 세어서 끝에 붙여줌

/*

다른 사람의 풀이
대단하다..

  public String solution(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split(""); //[ ,  , t, r, y,  , h, e, l, l, o,  , w, o, r, l, d,  , j, a, v, a,  ,  ,  ,  ]

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
        }
      return answer;
  }
  
 

*/