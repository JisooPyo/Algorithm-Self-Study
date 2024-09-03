package bookStudy.study2409;

import java.util.Arrays;

/**
 * 25. 트리 순회
 *
 * 이진 트리를 표현한 리스트 nodes를 인자로 받습니다.
 * 해당 이진 트리에 대하여 전위 순회, 중위 순회, 후위 순회 결과를 반환하는 solution() 함수를 구현하세요.
 *
 * 입출력의 예
 *
 * nodes
 * [1, 2, 3, 4, 5, 6, 7]
 * return
 * ["1 2 4 5 3 6 7", "4 2 5 1 6 3 7", "4 5 2 6 7 3 1"]
 */
public class Problem25 {
    public static void main(String[] args) {
        Problem25 p = new Problem25();
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(Arrays.toString(p.solution(nodes)));
    }

    int[] nodes;
    StringBuilder preorder;
    StringBuilder inorder;
    StringBuilder postorder;

    public String[] solution(int[] nodes) {
        this.nodes = nodes;
        preorder = new StringBuilder();
        inorder = new StringBuilder();
        postorder = new StringBuilder();

        String[] answer = new String[3];

        preorder(0);
        inorder(0);
        postorder(0);

        answer[0] = preorder.toString().trim();
        answer[1] = inorder.toString().trim();
        answer[2] = postorder.toString().trim();

        return answer;
    }

    // 왼쪽 -> 오른쪽 -> 부모
    private void postorder(int i) {
        if (i >= nodes.length) {
            return;
        }
        postorder(2 * i + 1);
        postorder(2 * i + 2);
        postorder.append(' ');
        postorder.append(nodes[i]);
    }

    // 왼쪽 -> 부모 -> 오른쪽
    private void inorder(int i) {
        if (i >= nodes.length) {
            return;
        }
        inorder(2 * i + 1);
        inorder.append(' ');
        inorder.append(nodes[i]);
        inorder(2 * i + 2);
    }

    // 부모 -> 왼쪽 -> 오른쪽
    private void preorder(int i) {
        if (i >= nodes.length) {
            return;
        }
        preorder.append(' ');
        preorder.append(nodes[i]);
        preorder(2 * i + 1);
        preorder(2 * i + 2);
    }
}
