package leetcode.al11;

public class Leet509 {
    public static void main(String[] args) {
        Leet509 leet509 = new Leet509();

        System.out.println(leet509.fib(2));
        System.out.println(leet509.fib(3));
        System.out.println(leet509.fib(4));
    }

    // Bottom-Up
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] store = new int[n + 1];
        store[0] = 0;
        store[1] = 1;
        for (int i = 2; i <= n; i++) {
            store[i] = store[i - 1] + store[i - 2];
        }
        return store[n];
    }
}
