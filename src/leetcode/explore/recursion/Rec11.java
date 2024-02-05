package leetcode.explore.recursion;

public class Rec11 {
    public static void main(String[] args) {
        Rec11 r = new Rec11();

        System.out.println(r.kthGrammar(1, 1));
        System.out.println(r.kthGrammar(2, 1));
        System.out.println(r.kthGrammar(2, 2));
        System.out.println(r.kthGrammar(30, 434991989));
    }

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int before = kthGrammar(n - 1, (k + 1) / 2);
        if (before == 0) {
            if (k % 2 == 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (k % 2 == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
