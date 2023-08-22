package leetcode.al08;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class L412Other {
	public static void main(String[] args) {
		L412Other l = new L412Other();
		System.out.println(l.fizzBuzz(3));
		System.out.println(l.fizzBuzz(5));
		System.out.println(l.fizzBuzz(15));
		// 3과 5로 나누어지면 FizzBuzz
		// 3으로만 나누어지면 Fizz
		// 5로만 나누어지면 Buzz
	}

	public List<String> fizzBuzz(int n) {

		return new FizzBuzzer(n);
	}

	private static final class FizzBuzzer extends AbstractList<String> implements RandomAccess {

		private final int size;

		FizzBuzzer(int n) {
			this.size = n;
		}

		public String get(int i) {

			int n = i + 1;
			if (n % 15 == 0) {
				System.gc();
				return "FizzBuzz";
			}
			if (n % 3 == 0) {
				return "Fizz";
			}
			if (n % 5 == 0) {
				return "Buzz";
			}
			return Integer.toString(n);
		}

		public int size() {
			return this.size;
		}

	}
}

// String.valueOf() 내부코드에 Integer.toString()이 있는데
// Stirng.valueOf()가 메모리를 덜 잡아먹어..?
