package leetcode.al11;

// Java program to calculate the value of nCr
public class Combination {
    public static void main(String[] args) {
        int n1 = 33;
        int r1 = 15;
        System.out.println("n: " + n1 + ", r: " + r1);
        System.out.println("Value of nCr: " + calculate_nCr(n1, r1));
    }

    private static long calculate_nCr(int n1, int r1) {
        int min = Math.min(n1 - r1, r1);
        long answer = 1;
        int multiple = n1;
        int division = 1;
        while (multiple >= n1 - min + 1 && division <= min) {
            if (multiple == n1 - min) {
                answer /= division;
                division++;
                continue;
            }
            answer *= multiple;
            multiple--;
            if (answer % division == 0) {
                answer /= division;
                division++;
            }
        }
        return answer;
    }


}
