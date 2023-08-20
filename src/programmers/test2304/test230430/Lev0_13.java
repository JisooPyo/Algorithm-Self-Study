package programmers.test2304.test230430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lev0_13 {

	public static void main(String[] args) {
		Lev0_13 lev = new Lev0_13();

		int[] t1 = { 1, 2, 3, 4, 5, 6 };
		int[] t2 = { 10000, 20, 36, 47, 40, 6, 10, 7000 };

		System.out.println(Arrays.toString(lev.solution(t1, 4)));
		System.out.println(Arrays.toString(lev.solution(t2, 30)));

	}

	public int[] solution(int[] numlist, int n) {
		// numlist를 String List 타입 list로 변환.
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < numlist.length; i++) {
			String num = "";
			num += numlist[i];
			strList.add(num);
		}

		// numlist를 IntegerList 타입 intList로 변환
		List<Integer> intList = Arrays.stream(numlist).boxed().collect(Collectors.toList());

		// numlist의 원소에서 n을 뺀 값을 넣는 array만들어 중복값 없애기
		int[] diff = new int[numlist.length]; // {3,2,1,0,1,2}
		for (int i = 0; i < diff.length; i++) {
			diff[i] = Math.abs(numlist[i] - n);
		}
		int[] diff2 = Arrays.stream(diff).distinct().toArray(); // diff에서 중복제거
		Arrays.sort(diff2);

		// 새롭게 정렬하며 값 추가할 list2 선언
		List<Integer> list2 = new ArrayList<>();
		// strList에서 값 빼서 list2에 add
		while (strList.size() > 0) {
			for (int d : diff2) {
				for (int i : intList) {
					// list2가 비었을 때는 list에서 num을 삭제하고 list2에 num을 넣는다.
					if (list2.size() == 0) {
						if (Math.abs(i - n) == d) {
							strList.remove(Integer.toString(i));
							list2.add(i);
						}

						// list2가 비지 않았을 때, 마지막 것과 넣으려는 num을 비교해서 넣는다.
					} else {
						if (Math.abs(i - n) == d) {
							int end = list2.get(list2.size() - 1);
							if (Math.abs(end - n) == Math.abs(i - n)) {
								if (end > i) {
									list2.add(i);
									strList.remove(Integer.toString(i));
								} else {
									list2.remove(list2.size() - 1);
									list2.add(i);
									list2.add(n - Math.abs(i - n));
									strList.remove(Integer.toString(i));
								}
							} else {
								list2.add(i);
								strList.remove(Integer.toString(i));
							}
						}
					}
				}
			}
		}

		int[] answer = list2.stream().mapToInt(i -> i).toArray();
		return answer;
	}

}
