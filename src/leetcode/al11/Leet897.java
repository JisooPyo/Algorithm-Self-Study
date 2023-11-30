package leetcode.al11;

public class Leet897 {
    public static void main(String[] args) {
        Leet897 leet897 = new Leet897();
        TreeNode t7 = new TreeNode(1);
        TreeNode t11 = new TreeNode(7);
        TreeNode t12 = new TreeNode(9);

        TreeNode t3 = new TreeNode(2, t7, null);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(8, t11, t12);

        TreeNode t1 = new TreeNode(3, t3, t4);
        TreeNode t2 = new TreeNode(6, null, t6);

        TreeNode t0 = new TreeNode(5, t1, t2);

        TreeNode answer = leet897.increasingBST(t0);
        // 1
        System.out.println(answer.val);
        // 2
        System.out.println(answer.right.val);
        // 3
        System.out.println(answer.right.right.val);
        // 4
        System.out.println(answer.right.right.right.val);
        // 5
        System.out.println(answer.right.right.right.right.val);
        // 6
        System.out.println(answer.right.right.right.right.right.val);
        // 7
        System.out.println(answer.right.right.right.right.right.right.val);
        // 8
        System.out.println(answer.right.right.right.right.right.right.right.val);
        // 9
        System.out.println(answer.right.right.right.right.right.right.right.right.val);
    }

    TreeNode answer;
    int min = Integer.MAX_VALUE;

    public TreeNode increasingBST(TreeNode root) {
        getMinimum(root);
        answer = new TreeNode(min);
        dfs(root);
        return answer;
    }

    private void getMinimum(TreeNode root) {
        if (root.val < min) {
            min = root.val;
        }
        if (root.left != null) {
            getMinimum(root.left);
        }
        if (root.right != null) {
            getMinimum(root.right);
        }
    }

    private void dfs(TreeNode root) {
        makeTree(root, answer);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

    private void makeTree(TreeNode root, TreeNode answer) {
        if (root.val == min) {
            return;
        }
        if (answer.right == null) {
            TreeNode treeNode = new TreeNode(root.val);
            answer.right = treeNode;
            return;
        }
        if (answer.val < root.val && root.val < answer.right.val) {
            TreeNode treeNode = new TreeNode(root.val);
            treeNode.right = answer.right;
            answer.right = treeNode;
            return;
        }
        makeTree(root, answer.right);
    }
}

/**
 * dfs를 하면서 int값을 list에 저장 후 정렬하고 list를 기준삼아 tree를 만들어도 됐겠다.
 */