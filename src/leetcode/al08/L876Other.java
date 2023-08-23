package leetcode.al08;

public class L876Other {
	public static void main(String[] args) {

	}

	public ListNode middleNode(ListNode head) {
		ListNode slow, fast, new_head;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		new_head = slow;
		return new_head;

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
