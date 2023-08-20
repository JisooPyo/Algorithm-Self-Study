package programmers.test2305.test230504;

import java.util.Arrays;

public class Lev1_011 {

	public static void main(String[] args) {
		Lev1_011 lev = new Lev1_011();

		System.out.println(lev.solution(118372));

	}

	public long solution(long n) {

		char[] ch = ("" + n).toCharArray();

		Integer[] ch_int = new Integer[ch.length];
		for (int i = 0; i < ch_int.length; i++) {
			ch_int[i] = Character.getNumericValue(ch[i]);
		}
		Arrays.sort(ch_int, (a, b) -> b - a);

		String n_str = "";
		for (int i = 0; i < ch_int.length; i++) {
			n_str += ch_int[i];

		}

		return Long.parseLong(n_str);
	}

}

/*

다른 사람의 풀이

역순 정렬이 아니라 정순 정렬을 한 뒤 reverse로 뒤집는 방법..!

import java.util.*;

class Solution {
  public long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
  }
}
*/