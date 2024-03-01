package leetcode.al2402;

public class Leet2864 {
    public static void main(String[] args) {
        Leet2864 l = new Leet2864();
        System.out.println(l.maximumOddBinaryNumber("010"));
        System.out.println(l.maximumOddBinaryNumber("0101"));
    }

    public String maximumOddBinaryNumber(String s) {
        int zero = 0;
        int one = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zero++;
                continue;
            }
            if (ch == '1') {
                one++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= one - 1; i++) {
            sb.append('1');
        }
        for (int i = 1; i <= zero; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}
