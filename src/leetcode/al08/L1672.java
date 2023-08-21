package leetcode.al08;

public class L1672 {
	public static void main(String[] args) {
		L1672 l = new L1672();

		int[][] accounts1 = {{1, 2, 3}, {3, 2, 1}};
		// 0번 고객 : 0번 은행에 1, 1번 은행에 2, 2번 은행에 3 -> 총 6
		// 1번 고객 : 0번 은행에 3, 1번 은행에 2, 2번 은행에 1 -. 총 6
		int[][] accounts2 = {{1, 5}, {7, 3}, {3, 5}};
		int[][] accounts3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
		System.out.println(l.maximumWealth(accounts1));
		System.out.println(l.maximumWealth(accounts2));
		System.out.println(l.maximumWealth(accounts3));
	}

	public int maximumWealth(int[][] accounts) {
		int wealth = 0;
		for (int i = 0; i < accounts.length; i++) {
			int sum = 0;
			for (int j = 0; j < accounts[i].length; j++) {
				sum += accounts[i][j];
			}
			if (wealth < sum) {
				wealth = sum;
			}
		}
		return wealth;
	}
}
