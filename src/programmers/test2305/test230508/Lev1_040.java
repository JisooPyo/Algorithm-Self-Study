// 문자열 내 마음대로 정렬하기

package programmers.test2305.test230508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lev1_040 {

	public static void main(String[] args) {
		Lev1_040 lev = new Lev1_040();

		String[] t1 = { "sun", "bed", "car" };
		String[] t2 = { "abce", "abcd", "aacb", "cdx" };

		System.out.println(Arrays.toString(lev.solution(t1, 1)));
		System.out.println(Arrays.toString(lev.solution(t2, 2)));

	}

	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings);
		List<String> list = new ArrayList<>(Arrays.asList(strings));
		List<String> newlist = new ArrayList<>();
		while (list.size() > 0) {
			char compare = 'z';
			int index = 0;
			for (int i = 0; i < list.size(); i++) {
				if (compare > list.get(i).charAt(n)) {
					compare = list.get(i).charAt(n);
					index = i;
				}
			}
			newlist.add(list.get(index));
			list.remove(index);
		}
		return newlist.toArray(new String[newlist.size()]);
	}

}

/*

다른 사람의 풀이

판별할 문자열을 앞에다 두고 정렬한 뒤, substring으로 다시 배열 만들기.

public String[] solution(String[] strings, int n) {
	String[] answer = {};
	ArrayList<String> arr = new ArrayList<>();
	for (int i = 0; i < strings.length; i++) {
    	arr.add("" + strings[i].charAt(n) + strings[i]);
	}

	Collections.sort(arr);

	answer = new String[arr.size()];

	for (int i = 0; i < arr.size(); i++) {
    	answer[i] = arr.get(i).substring(1, arr.get(i).length());
	}

	return answer;
}

*/