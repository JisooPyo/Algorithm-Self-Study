package leetcode.al2407;

/**
 * Medium
 * 1530. Number of Good Leaf Nodes Pairs
 *
 * 이진 트리의 root 와 정수 distance 가 주어진다.
 * 이진 트리의 두 다른 리프 노드의 한 쌍이
 * 만약 두 노드 사이 가장 짧은 거리가 distance 보다 짧거나 같다면 "good"이라고 할 수 있다.
 *
 * 트리에서 "good"인 리프 노드 쌍들의 수를 구하라.
 */
public class Leet1530_x {
    public static void main(String[] args) {
        Leet1530_x l = new Leet1530_x();
        l.problem1();   // 1
        l.problem2();   // 2
        l.problem3();   // 1
    }

    private void problem1() {
        TreeNode t4 = new TreeNode(4);

        TreeNode t2 = new TreeNode(2, null, t4);
        TreeNode t3 = new TreeNode(3);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(countPairs(t1, 3));
    }

    private void problem2() {
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);

        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(countPairs(t1, 3));
    }

    private void problem3() {
        TreeNode t2 = new TreeNode(2);

        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3, null, t2);

        TreeNode t1 = new TreeNode(1, t6, null);
        TreeNode t4 = new TreeNode(4, t5, t3);

        TreeNode t7 = new TreeNode(7, t1, t4);
        System.out.println(countPairs(t7, 3));
    }

    // 다른 사람의 풀이 : 2ms
    int result;

    public int countPairs(TreeNode root, int distance) {
        result = 0;
        dfs(root, distance);
        return result;
    }

    int[] dfs(TreeNode root, int distance) {
        // 각 인덱스가 리프 노드까지의 거리 [0, ... , 0]은 리프 노드가 없다는 것을 뜻함
        if (root == null) {
            return new int[distance + 1];
        }

        // 노드가 리프 노드인 경우, 리프 노드까지의 거리가 1인 배열을 반환
        if (root.left == null && root.right == null) {
            int[] res = new int[distance + 1];
            res[1]++;
            return res;
        }

        // 왼쪽 서브트리와 오른쪽 서브트리에서 리프 노드까지의 거리 배열을 가져옴
        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);

        // 두 서브트리에서 리프 노드까지의 거리 배열을 비교하여 거리가 distance 이하인 쌍의 수를 계산
        for (int l = 1; l < left.length; l++) {
            for (int r = distance - 1; r >= 0; r--) {
                if (l + r <= distance)
                    // left[l] : 리프 노드까지의 거리가 l인 리프 노드의 개수
                    // right[r] : 리프 노드까지의 거리가 r인 리프 노드의 개수
                    result += left[l] * right[r];
            }
        }

        // 현재 노드의 거리 배열을 생성하여 병합
        int[] res = new int[distance + 1];

        // 거리를 1씩 증가시키며 배열 병합
        for (int i = res.length - 2; i >= 1; i--) {
            res[i + 1] = left[i] + right[i];
        }

        return res;
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
