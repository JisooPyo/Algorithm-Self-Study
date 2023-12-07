package leetcode.al12;

public class ArrayAndString16 {
    public static void main(String[] args) {
        ArrayAndString16 aas16 = new ArrayAndString16();
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";

        System.out.println(aas16.reverseWords(s1));     // "blue is sky the"
        System.out.println(aas16.reverseWords(s2));     // "world hello"
        System.out.println(aas16.reverseWords(s3));     // "example good a"
    }

    public String reverseWords(String s) {
        String[] split = s.trim().split(" +");

        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
