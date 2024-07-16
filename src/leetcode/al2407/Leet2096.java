package leetcode.al2407;

/**
 * Medium
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 *
 * n개의 노드로 이루어진 이진 트리의 root 가 주어집니다.
 * 각각의 노드는 unique 하게 1부터 n까지 값을 할당받습니다.
 * 또한 시작 노드 s의 값을 나타내는 정수 startValue 가 주어집니다.
 * 또한 도착 노드 t의 값은 나타내는 또 다른 정수 destValue 가 주어집니다.
 *
 * 노드 s에서 시작하고, 노드 t에 도착하는 가장 짧은 경로를 구하여라.
 * 대문자 L, R, U로 이루어진 문자열로 각 경로의 단계별 방향을 생성하라.
 * 각 문자는 특정한 방향을 나타낸다.
 *   - L은 한 노드에서 그의 왼쪽 자식 노드로 가는 것을 의미합니다.
 *   - R은 한 노드에서 그의 오른쪽 자식 노드로 가는 것을 의미합니다.
 *   - U는 한 노드에서 부모 노드로 이동하는 것을 이동합니다.
 */
public class Leet2096 {
    public static void main(String[] args) {
        Leet2096 leet2096 = new Leet2096();

        leet2096.problem1();
        leet2096.problem2();
    }

    private void problem2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2, n1, null);
        // L
        System.out.println(getDirections(n2, 2, 1));
    }

    private void problem1() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);

        TreeNode n1 = new TreeNode(1, n3, null);
        TreeNode n2 = new TreeNode(2, n6, n4);

        TreeNode n5 = new TreeNode(5, n1, n2);
        // UURL
        System.out.println(getDirections(n5, 3, 6));

    }

    // Memory Limit Exceeded
    // -> boolean found flag 를 세우고 new StringBuilder -> sb.deleteCharAt(sb.length() - 1)로 수정
    // 나의 풀이 : 27ms
    String[] startEndStrings;
    boolean found;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        startEndStrings = new String[2];
        found = false;
        getPathString(root, startValue, new StringBuilder(), 0);
        found = false;
        getPathString(root, destValue, new StringBuilder(), 1);
        String start = startEndStrings[0];
        String end = startEndStrings[1];
        int index = 0;
        int min = Math.min(start.length(), end.length());
        for (int i = 0; i < min; i++) {
            if (start.charAt(i) == end.charAt(i)) {
                index++;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < start.length(); i++) {
            sb.append('U');
        }
        sb.append(end.substring(index));
        return sb.toString();
    }

    private void getPathString(TreeNode node, int value, StringBuilder sb, int index) {
        if (found || node == null) {
            return;
        }
        if (node.val == value) {
            startEndStrings[index] = sb.toString();
            found = true;
            return;
        }
        if (node.left != null) {
            sb.append('L');
            getPathString(node.left, value, sb, index);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (node.right != null) {
            sb.append('R');
            getPathString(node.right, value, sb, index);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // 다른 사람의 풀이 : 16ms
    // path를 StringBuilder가 아니라 byte배열에 저장하여 해결.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
