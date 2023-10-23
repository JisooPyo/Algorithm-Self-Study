package programmers.test2310;

import java.util.Arrays;

public class PhoneNumberList {
	public static void main(String[] args) {
		PhoneNumberList pnl = new PhoneNumberList();

		String[] phoneBook1 = {"119", "97674223", "1195524421"};
		String[] phoneBook2 = {"123", "456", "789"};
		String[] phoneBook3 = {"12", "123", "1235", "567", "88"};

		System.out.println(pnl.solution(phoneBook1));
		System.out.println(pnl.solution(phoneBook2));
		System.out.println(pnl.solution(phoneBook3));
	}

	// phone_book의 길이는 1이상 1,000,000 이하
	// 각 전화번호의 길이는 1이상 20 이하
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				return false;
			}
		}

		return true;
	}
}

