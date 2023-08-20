package programmers.test2304.test230419;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindLetterProblem {

	public static void main(String[] args) {
		FindLetterProblem fl = new FindLetterProblem();

		String x = "abcabcadc";
		String y = "abdc";
		String z = "hello";
		
		System.out.println(fl.solution(x));
		System.out.println(fl.solution(y));
		System.out.println(fl.solution(z));
		
	}

	public String solution(String s) {
		StringBuilder answer = new StringBuilder();
		
		char[] ch = s.toCharArray();
		
		Set<Character> set1 = new LinkedHashSet<>();
		
		for (char c : ch) {
			set1.add(c);
		}
		
		Character[] arr = set1.toArray(new Character[0]);
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < ch.length; j++) {
				if (arr[i].equals(ch[j])) {
					count++;
				}
			}
			if (count == 1) {
				sb.append(arr[i]);
			}
		}
				
		char[] ch2 = sb.toString().toCharArray(); 
		Arrays.sort(ch2);
		for(char c : ch2 ) {
			answer.append(c);
		}
		
		return answer.toString();
	}

}

/*

다른 사람의 풀이
알파벳 array에 개수를 저장하여 그 인덱스를 활용하여 answer에 순서대로 넣음.

public String solution(String s) {
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 1){
                answer.append((char)(i + 'a'));
            }
        }
        return answer.toString();
    }

*/