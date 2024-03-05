package leetcode.al2403;

public class Leet1750 {
    public static void main(String[] args) {
        Leet1750 l = new Leet1750();

        System.out.println(l.minimumLength("ca"));
        System.out.println(l.minimumLength("cabaabac"));
        System.out.println(l.minimumLength("aabccabba"));
    }

    // StringBuilder로 문자열 확인할 필요 없이 pointer만 움직여서 확인해도 됨
    public int minimumLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            int length = sb.length();
            if (left + 1 == right) {
                if (sb.charAt(left) == sb.charAt(right)) {
                    sb = new StringBuilder();
                    break;
                }
            }
            if (sb.charAt(left) != sb.charAt(right)) {
                break;
            }
            if (sb.charAt(left) == sb.charAt(left + 1)) {
                left++;
                continue;
            }
            if (sb.charAt(right) == sb.charAt(right - 1)) {
                right--;
                continue;
            }
            sb.delete(right, length);
            sb.delete(0, left + 1);
            left = 0;
            right = sb.length() - 1;
            continue;
        }
        return sb.length();
    }
}
