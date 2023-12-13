package leetcode.explore.arrayAndString;

public class ArrayAndString17 {
    public static void main(String[] args) {
        ArrayAndString17 aas17 = new ArrayAndString17();
        String s1 = "Let's take LeetCode contest";
        String s2 = "Mr Ding";

        System.out.println(aas17.reverseWords(s1));     // "s'teL ekat edoCteeL tsetnoc"
        System.out.println(aas17.reverseWords(s2));     // "rM gniD"
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        StringBuilder answer = new StringBuilder();
        StringBuilder words = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                answer.append(words.reverse());
                answer.append(ch);
                words = new StringBuilder();
                continue;
            }
            words.append(ch);
        }
        answer.append(words.reverse());

        return answer.toString();
    }
}
