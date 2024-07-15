package leetcode.al2407;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Medium
 * 2196. Create Binary Tree From Descriptions
 *
 * parent_i는 unique 한 값들의 이진 트리에서 child_i의 부모일 때,
 * description[i] = [parent_i, child_i, isLeft_i]인 2D 정수 배열 descriptions 이 주어진다.
 *
 * 만약 isLeft_i == 1이라면, child_i는 parent_i의 왼쪽 아이이다.
 * 만약 isLeft_i == 0 이라면, child_i는 parent_i의 오른쪽 아이이다.
 *
 * descriptions 으로 묘사된 이진 트리를 구성하고 그의 root 를 반환하라.
 *
 * 테스트 케이스는 이진 트리가 유효하게끔 만들어진다.
 *
 * Constraints:
 *
 *   1 <= descriptions.length <= 10^4
 *   descriptions[i].length == 3
 *   1 <= parent_i, child_i <= 10^5
 *   0 <= isLeft_i <= 1
 *   The binary tree described by descriptions is valid.
 */
public class Leet2196 {
    public static void main(String[] args) {
        Leet2196 leet2196 = new Leet2196();
        // [parent_i, child_i, isLeft_i]
        int[][] descriptions1 = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        int[][] descriptions2 = {{1, 2, 1}, {2, 3, 0}, {3, 4, 1}};
        int[][] descriptions3 = {
            {85, 82, 1}, {74, 85, 1},
            {39, 70, 0}, {82, 38, 1},
            {74, 39, 0}, {39, 13, 1}};

        // TreeNode t1 = leet2196.createBinaryTree(descriptions1);
        // TreeNode t2 = leet2196.createBinaryTree(descriptions2);
        TreeNode t3 = leet2196.createBinaryTree(descriptions3);
    }

    // 내 풀이 : 12ms
    public TreeNode createBinaryTree(final int[][] descriptions) {
        final TreeNode[] nodes = new TreeNode[100001];
        final boolean[] children = new boolean[100001];

        for(final int[] description : descriptions) {
            if(nodes[description[0]] == null)
                nodes[description[0]] = new TreeNode(description[0]);

            if(nodes[description[1]] == null)
                nodes[description[1]] = new TreeNode(description[1]);

            if(description[2] == 0)
                nodes[description[0]].right = nodes[description[1]];
            else
                nodes[description[0]].left = nodes[description[1]];

            children[description[1]] = true;
        }

        for(final int[] description : descriptions)
            if(!children[description[0]])
                return nodes[description[0]];

        return null;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}
