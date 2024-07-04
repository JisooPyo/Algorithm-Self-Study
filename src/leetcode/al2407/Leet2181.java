package leetcode.al2407;

/**
 Medium
 2181. Merge Nodes in Between Zeros

 정수들이 0으로 구분된 연결 리스트의 head 가 주어집니다.
 연결 리스트의 시작과 끝은 Node.val == 0입니다.

 연속된 두 개의 0 사이에 있는 모든 노드를 하나의 노드로 병합합니다.
 병합된 노드의 값은 병합된 모든 노드의 합계입니다.
 수정된 리스트는 0을 포함하지 않아야 합니다.

 수정된 연결 리스트의 head 를 반환하세요.
 */
public class Leet2181 {
    // 재귀로 풀려다가 잘 안됐다.
    // 다른 사람의 풀이 : 6ms
    public ListNode mergeNodes(ListNode head) {
        // 새로운 더미 노드 생성 (결과 링크드 리스트의 시작점)
        ListNode dummy = new ListNode(0);
        // 새로운 리스트의 현재 노드를 가리키는 포인터
        ListNode current = dummy;
        // 값의 합을 저장할 변수
        int sum = 0;

        // head의 첫 번째 노드는 항상 0이므로, 다음 노드부터 시작
        head = head.next;

        while (head != null) {
            if (head.val == 0) {
                // 0을 만나면, 합산된 값을 새로운 노드로 추가
                current.next = new ListNode(sum);
                current = current.next;
                // 합산 변수 초기화
                sum = 0;
            } else {
                // 0이 아니면, 값을 합산
                sum += head.val;
            }
            // 다음 노드로 이동
            head = head.next;
        }

        // 더미 노드의 다음 노드를 반환 (결과 링크드 리스트의 시작점)
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
