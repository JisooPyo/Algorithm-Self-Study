package leetcode.al2405;

public class Leet2000 {
    public static void main(String[] args) {
        Leet2000 l = new Leet2000();

        System.out.println(l.reversePrefix("abcdefd", 'd'));
        System.out.println(l.reversePrefix("xyxzxe", 'z'));
        System.out.println(l.reversePrefix("abcd", 'z'));
    }

    public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        for (int i = index + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
