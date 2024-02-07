package leetcode.explore.recursion;

import java.util.ArrayList;
import java.util.List;

public class Rec12_x {
    public static void main(String[] args) {
        Rec12_x solution = new Rec12_x();
        List<TreeNode> result = solution.generateTrees(3);
        solution.printTrees(result);
    }

    // gpt 풀이
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    // 주어진 범위의 숫자로 구성된 모든 유일한 BST를 생성하는 메서드
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        // 범위가 유효하지 않을 때 비어있는 트리를 생성하여 반환
        if (start > end) {
            trees.add(null);
            return trees;
        }

        // i를 root로 하는 Tree를 만든다.
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    // Helper method to print trees (for testing)
    public void printTrees(List<TreeNode> trees) {
        for (TreeNode tree : trees) {
            printTree(tree);
            System.out.println();
        }
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

}
