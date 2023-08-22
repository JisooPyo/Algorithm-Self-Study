package leetcode.al08;

import java.util.ArrayList;
import java.util.List;

public class L412 {
	public static void main(String[] args) {
		L412 l = new L412();
		System.out.println(l.fizzBuzz(3));
		System.out.println(l.fizzBuzz(5));
		System.out.println(l.fizzBuzz(15));
		// 3과 5로 나누어지면 FizzBuzz
		// 3으로만 나누어지면 Fizz
		// 5로만 나누어지면 Buzz
	}

	public List<String> fizzBuzz(int n) {
		List<String> answers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				answers.add("FizzBuzz");
			} else if (i % 3 == 0) {
				answers.add("Fizz");
			} else if (i % 5 == 0) {
				answers.add("Buzz");
			} else {
				answers.add(String.valueOf(i));
			}
		}
		return answers;
	}
}

// String.valueOf() 내부코드에 Integer.toString()이 있는데
// Stirng.valueOf()가 메모리를 덜 잡아먹어..?
