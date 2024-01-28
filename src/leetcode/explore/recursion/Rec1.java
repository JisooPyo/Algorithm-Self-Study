package leetcode.explore.recursion;

public class Rec1 {
    public static void main(String[] args) {
        Rec1 r = new Rec1();
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};

        r.reverseString(s1);
        r.reverseString(s2);
        System.out.println(s1);
        System.out.println(s2);
    }

    public void reverseString(char[] s) {
        rec(s, 0);
    }

    private void rec(char[] s, int i) {
        if (i == (s.length + 1) / 2) {
            return;
        }
        char temp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i] = temp;
        rec(s, i + 1);
    }
}
