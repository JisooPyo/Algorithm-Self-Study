package leetcode.al2404;

public class Leet1544 {
    public static void main(String[] args) {
        Leet1544 l = new Leet1544();
        System.out.println(l.makeGood("leEeetcode"));
        System.out.println(l.makeGood("abBAcC"));
    }

    // 내 풀이
    public String makeGood(String s) {
        int diff = 'a' - 'A';
        StringBuilder sb = new StringBuilder(s);
        loop1:
        while (true) {
            for (int i = 0; i < sb.length() - 1; i++) {
                int charDiff = sb.charAt(i + 1) - sb.charAt(i);
                if (charDiff == diff || charDiff == -diff) {
                    sb.delete(i, i + 2);
                    continue loop1;
                }
            }
            break;
        }
        return sb.toString();
    }

    // 다른 사람의 풀이
    // 중간에 if 조건문을 Math.abs() 메서드를 이용하여 하나의 조건으로 만들어 줄 수도 있다.
}
