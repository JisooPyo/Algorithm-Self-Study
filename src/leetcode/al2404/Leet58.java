package leetcode.al2404;

public class Leet58 {
    public static void main(String[] args) {
        Leet58 l = new Leet58();
        System.out.println(l.lengthOfLastWord("Hello World"));
        System.out.println(l.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(l.lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        String[] splits = s.split(" +");
        return splits[splits.length - 1].length();
    }
}
