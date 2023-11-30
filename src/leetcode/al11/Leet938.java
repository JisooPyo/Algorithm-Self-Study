package leetcode.al11;

public class Leet938 {
    public static void main(String[] args) {
        Leet938 leet938 = new Leet938();
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(7);
        TreeNode t6 = new TreeNode(18);
        TreeNode t1 = new TreeNode(5, t3, t4);
        TreeNode t2 = new TreeNode(15, null, t6);
        TreeNode t0 = new TreeNode(10, t1, t2);

        System.out.println(leet938.rangeSumBST(t0, 7, 15)); // 32

        TreeNode r7 = new TreeNode(1);
        TreeNode r9 = new TreeNode(6);
        TreeNode r3 = new TreeNode(3, r7, null);
        TreeNode r4 = new TreeNode(7, r9, null);
        TreeNode r5 = new TreeNode(13);
        TreeNode r6 = new TreeNode(18);
        TreeNode r1 = new TreeNode(5, r3, r4);
        TreeNode r2 = new TreeNode(15, r5, r6);
        TreeNode r0 = new TreeNode(10, r1, r2);

        System.out.println(leet938.rangeSumBST(r0, 6, 10)); // 23
    }

    int answer = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return answer;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (low <= root.val && root.val <= high) {
            answer += root.val;
        }
        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }
}
