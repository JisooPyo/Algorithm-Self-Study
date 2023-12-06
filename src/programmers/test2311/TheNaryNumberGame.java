package programmers.test2311;

public class TheNaryNumberGame {
    public static void main(String[] args) {
        TheNaryNumberGame g = new TheNaryNumberGame();

        // "0111"
        System.out.println(g.solution(2, 4, 2, 1));
        // "02468ACE11111111"
        // "02468ace11111111"
        System.out.println(g.solution(16, 16, 2, 1));
        // "13579BDF01234567"
        // "13579bdf01234567"
        System.out.println(g.solution(16, 16, 2, 2));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder numbers = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        // sb의 index
        int index = p;

        // n진법으로 바꿀 숫자
        int number = 0;
        while (!(numbers.length() == t)) {
            sb.append(Integer.toString(number++, n));
            if (sb.length() >= index) {
                numbers.append(sb.charAt(index - 1));
                sb.delete(0, index);
                index = m;
            }
        }

        return numbers.toString().toUpperCase();
    }
}
