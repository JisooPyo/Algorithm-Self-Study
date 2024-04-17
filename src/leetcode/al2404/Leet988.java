package leetcode.al2404;

import java.util.Arrays;

public class Leet988 {
    public static void main(String[] args) {
        Leet988 l = new Leet988();
        l.problem1();
        l.problem2();
    }

    private void problem2() {
        TreeNode t6 = new TreeNode(0);

        TreeNode t5 = new TreeNode(1, t6, null);

        TreeNode t3 = new TreeNode(0, t5, null);
        TreeNode t4 = new TreeNode(0);

        TreeNode t2 = new TreeNode(1, t3, t4);

        TreeNode t1 = new TreeNode(25, t2, null);

        System.out.println(smallestFromLeafOther(t1));
    }

    private void problem1() {
        TreeNode t4 = new TreeNode(1);

        TreeNode t2 = new TreeNode(0, t4, null);
        TreeNode t3 = new TreeNode(1);

        TreeNode t1 = new TreeNode(4, t2, t3);

        System.out.println(smallestFromLeaf(t1));
    }

    // 내 풀이
    public String smallestFromLeaf(TreeNode root) {
        return rec(root, String.valueOf((char)(root.val + 'a')));
    }

    private String rec(TreeNode root, String str) {
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();

        if (root.left != null) {
            sbLeft = new StringBuilder(rec(root.left, (char)(root.left.val + 'a') + str));
        }
        if (root.right != null) {
            sbRight = new StringBuilder(rec(root.right, (char)(root.right.val + 'a') + str));
        }
        if (root.left == null && root.right == null) {
            return str;
        }

        return pickSmallestString(sbLeft.toString(), sbRight.toString());
    }

    private String pickSmallestString(String left, String right) {
        if (left.isEmpty() || right.isEmpty()) {
            if (left.isEmpty()) {
                return right;
            } else {
                return left;
            }
        }

        if (left.equals(right)) {
            return left;
        }

        int len = Math.min(left.length(), right.length());

        for (int i = 0; i < len; i++) {
            char chL = left.charAt(i);
            char chR = right.charAt(i);
            if (chL < chR) {
                return left;
            } else if (chL > chR) {
                return right;
            }
        }
        if (left.length() < right.length()) {
            return left;
        } else {
            return right;
        }
    }

    // 다른 사람 풀이
    char[] chs = null;
    int l = 0;

    // 1. TreeNode의 최대 depth를 구한다.
    // 2. depth만큼의 배열을 만든다.
    // 3. 첫 잎 노드에 도달하면 트리경로를 따라 배열을 채워넣는다.
    // 4. 다른 잎 노드에 도달하면 현재 경로 t와 이전 경로인 chs를 비교하여 최소값을 업데이트한다.
    public String smallestFromLeafOther(TreeNode root) {
        int d = depth(root);
        solve(root, new char[d], d - 1);
        return new String(chs, l, d - l);
    }

    // TreeNode의 최대 depth를 구한다.
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private void solve(TreeNode node, char[] t, int i) {
        if (node == null) {
            return;
        }
        t[i] = (char)('a' + node.val);
        if (node.left == null && node.right == null) {
            if (chs == null) {
                chs = Arrays.copyOf(t, t.length);
                l = i;
            } else {
                for (int k = 0, d = Math.max(l, i); k + d < t.length; k++) {
                    if (chs[l + k] < t[i + k]) {
                        return;
                    } else if (chs[l + k] > t[i + k]) {
                        chs = Arrays.copyOf(t, t.length);
                        l = i;
                        return;
                    }
                }
                if (l < i) {
                    chs = Arrays.copyOf(t, t.length);
                    l = i;
                }
            }
            return;
        }
        solve(node.left, t, i - 1);
        solve(node.right, t, i - 1);
    }
}
