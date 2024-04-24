package leetcode.al2404;

public class Leet1137 {
    public int tribonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1, 2:
                return 1;
        }

        int[] record = new int[n + 1];
        record[0] = 0;
        record[1] = 1;
        record[2] = 1;
        for (int i = 3; i <= n; i++) {
            record[i] = record[i - 1] + record[i - 2] + record[i - 3];
        }
        return record[n];
    }
}
