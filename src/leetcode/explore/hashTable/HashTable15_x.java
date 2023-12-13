package leetcode.explore.hashTable;

import leetcode.al11.TreeNode;

import java.util.*;

public class HashTable15_x {
    public static void main(String[] args) {
        HashTable15_x h = new HashTable15_x();
        TreeNode t10 = new TreeNode(4);

        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(2, t10, null);
        TreeNode t7 = new TreeNode(4);

        TreeNode t2 = new TreeNode(2, t4, null);
        TreeNode t3 = new TreeNode(3, t6, t7);

        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(h.findDuplicateSubtrees(t1));
    }

    // 우리는 후위 순회를 수행하여 프로세스에서 하위 트리의 직렬화를 직렬화하고 해싱합니다.
    // 직렬화를 통해 중복된 하위 트리를 인식할 수 있습니다.
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) res.add(cur);
        return serial;
    }

    // 위의 시간 복잡도는 O(n^2)입니다. 전체 직렬화를 직렬 ID로 대체하여 이를 O(n)으로 개선할 수 있습니다.
    int curId = 1;

    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        Map<String, Integer> serialToId = new HashMap<>();
        Map<Integer, Integer> idToCount = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        postorder(root, serialToId, idToCount, res);
        return res;
    }

    private int postorder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
        if (root == null) return 0;
        int leftId = postorder(root.left, serialToId, idToCount, res);
        int rightId = postorder(root.right, serialToId, idToCount, res);
        String curSerial = leftId + "," + root.val + "," + rightId;
        int serialId = serialToId.getOrDefault(curSerial, curId);
        if (serialId == curId) curId++;
        serialToId.put(curSerial, serialId);
        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
        if (idToCount.get(serialId) == 2) res.add(root);
        return serialId;
    }

    // 4ms 빠른 풀이(위의 풀이: 10ms) : 위의 풀이에서 concat을 StringBuilder append로 바꾸기만 함!
    public List<TreeNode> findDuplicateSubtrees3(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        solve(root, map, count, list);

        return list;
    }

    int solve(TreeNode root, Map<String, Integer> map,
              Map<Integer, Integer> count, List<TreeNode> list) {
        if (root == null) return 0;

        int left = solve(root.left, map, count, list);
        int right = solve(root.right, map, count, list);

        StringBuilder str = new StringBuilder();
        str.append(root.val).append(",");
        str.append(left).append(",").append(right);

        String key = str.toString();

        int id = map.computeIfAbsent(key, k -> map.size() + 1);
        count.put(id, count.getOrDefault(id, 0) + 1);

        if (count.get(id) == 2) list.add(root);

        return id;
    }
}
