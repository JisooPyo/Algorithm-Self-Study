// 두 개 뽑아서 더하기
package programmers.test2308;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeHashSet {
	public static void main(String[] args) {

		long one = System.currentTimeMillis();

		Set<Integer> set = new HashSet<>();
		for (int i = 10_000_000; i >= 1; i--) {
			set.add(i);
		}

		long two = System.currentTimeMillis();

		int[] setArr = new int[10_000_000];
		int index = 0;
		for (Integer i : set) {
			setArr[index++] = i;
		}

		long three = System.currentTimeMillis();

		Arrays.sort(setArr);

		long four = System.currentTimeMillis();

		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int i = 10_000_000; i >= 1; i--) {
			treeSet.add(i);
		}

		long five = System.currentTimeMillis();

		int[] treeSetArr = new int[10_000_000];
		int index2 = 0;
		for (Integer i : treeSet) {
			treeSetArr[index2++] = i;
		}

		long six = System.currentTimeMillis();


		System.out.println(two - one); // 524 >> hashset add -> O(1)
		System.out.println(three - two); // 107 >> hashSet -> array
		System.out.println(four - three); // 350 >> Arrays.sort

		System.out.println(four - one); // 981 >> hashSet 총 시간
		////////////////////////////////////////////////////////
		System.out.println(five - four); // 1968 >> treeset add -> O(logN)
		System.out.println(six - five); // 96 >> treeset -> Array

		System.out.println(six - four); // 2064 >> treeSet 총시간

		double d = 0;
		for (int i = 1; i <= 10_000_000; i++) {
			d += Math.log(i);
		}
		System.out.println(d);

	}

}
