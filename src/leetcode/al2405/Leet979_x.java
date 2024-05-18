package leetcode.al2405;

/**
 * 979. Distribute Coins in Binary Tree
 *
 * Given
 * root: n개의 노드를 가지는 2진트리
 *       트리의 각 노드는 node.val개 만큼의 코인을 가지고 있다.
 *       전체 트리의 코인을 전부 합하면 n개
 *
 * 한 번 움직일 때, 두 개의 인접한 노드를 골라 한 노드에서 다른 노드로 한 개의 코인을 움직인다.
 * 움직임은 부모에서 자식으로, 또는 자식에서 부모로 이동한다.
 *
 * Return
 * 모든 노드가 정확히 한 개의 코인을 가지는 최소한의 움직임 수
 */
public class Leet979_x {
    // 감도 못 잡았음..;ㅅ;

    // 다른 사람의 풀이
    // 설명을 봤는데도 이해하기 어렵다!
    // 만약 노드의 값이 0이라면 1이 되기 위해 하나의 move를 필요로 하고
    // 값이 1이라면 move를 필요로 하지 않고
    // 값이 1보다 크다면 1을 뺀 나머지만큼의 move를 필요로 한다.. 는 아이디어에서 시작하는 것 같다.
    // 이것을 바탕으로 문제를 푸는 것 같다.. 흠.. 어렵다..
    public int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        countSteps(root);
        return ans;
    }

    public int countSteps(TreeNode root) {
        if (root == null)
            return 0;
        int leftCoins = countSteps(root.left);
        int rightCoins = countSteps(root.right);
        ans += Math.abs(leftCoins) + Math.abs(rightCoins);
        return (root.val - 1) + leftCoins + rightCoins;
    }

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
