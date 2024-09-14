package bookStudy.study2409;

import java.util.Arrays;
import java.util.Stack;

/**
 * 프로그래머스 lv.3
 * 표 편집
 */
public class Problem14 {
    public static void main(String[] args) {
        Problem14 p = new Problem14();

        String[] cmd1 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String[] cmd2 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        String[] cmd3 = {"C"};

        System.out.println(p.solution(8, 2, cmd1)); // "OOOOXOOO"
        System.out.println(p.solution(8, 2, cmd2)); // "OOXOXOOO"
        System.out.println(p.solution(8, 7, cmd3));
    }

    // 처음에 boolean[]로 구현 -> 시간복잡도가 너무 커짐.

    // 양방향 LinkedList를 직접 구현해야 할 것 같다.
    public String solution(int n, int k, String[] cmd) {
        // 노드로 구현
        Node[] nodes = new Node[n];
        nodes[0] = new Node(0, null, null);
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node(i, nodes[i - 1], null);
            nodes[i - 1].next = nodes[i];
        }

        // 삭제된 노드 저장할 스택
        Stack<Node> removed = new Stack<>();
        Node cur = nodes[k];
        for (int i = 0; i < cmd.length; i++) {
            char ch = cmd[i].charAt(0);
            int x;
            switch (ch) {
                case 'U':
                    x = getX(cmd[i]);
                    while (x > 0) {
                        cur = cur.prev;
                        x--;
                    }
                    break;
                case 'D':
                    x = getX(cmd[i]);
                    while (x > 0) {
                        cur = cur.next;
                        x--;
                    }
                    break;
                case 'C':
                    if (cur.next == null) {
                        cur = cur.prev;
                        removed.push(cur.next);
                        cur.next = null;
                    } else {
                        cur = cur.next;
                        removed.push(cur.prev);
                        cur.prev = cur.prev.prev;
                        if (cur.prev != null) {
                            cur.prev.next = cur;
                        }
                    }
                    break;
                case 'Z':
                    Node recentDeleted = removed.pop();
                    Node prev = recentDeleted.prev;
                    Node next = recentDeleted.next;
                    if (prev != null) {
                        prev.next = recentDeleted;
                    }
                    if (next != null) {
                        next.prev = recentDeleted;
                    }
            }
        }

        // 첫 root 노드로 되돌아가기
        while (cur.prev != null) {
            cur = cur.prev;
        }

        char[] chars = new char[n];
        Arrays.fill(chars, 'O');
        while (!removed.isEmpty()) {
            chars[removed.pop().index] = 'X';
        }
        return new String(chars);
    }

    private int getX(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    class Node {
        int index;
        Node prev;
        Node next;

        public Node(int index, Node prev, Node next) {
            this.index = index;
            this.prev = prev;
            this.next = next;
        }

        /*
        @Override
        public String toString() {
            return "Node{" +
                "index=" + index +
                ", prev=" + (prev == null ? "null" : prev.index) +
                ", next=" + (next == null ? "null" : next.index) +
                "}";
        }
        */
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.36ms, 75.3MB)
테스트 2 〉	통과 (0.46ms, 77.6MB)
테스트 3 〉	통과 (0.30ms, 78.6MB)
테스트 4 〉	통과 (0.46ms, 79.5MB)
테스트 5 〉	통과 (0.62ms, 71.5MB)
테스트 6 〉	통과 (0.61ms, 79MB)
테스트 7 〉	통과 (0.58ms, 79.4MB)
테스트 8 〉	통과 (0.48ms, 78.5MB)
테스트 9 〉	통과 (0.35ms, 69.2MB)
테스트 10 〉	통과 (0.42ms, 71.1MB)
테스트 11 〉	통과 (1.37ms, 77MB)
테스트 12 〉	통과 (1.35ms, 85.8MB)
테스트 13 〉	통과 (1.56ms, 75.2MB)
테스트 14 〉	통과 (1.70ms, 79MB)
테스트 15 〉	통과 (1.06ms, 77.9MB)
테스트 16 〉	통과 (1.12ms, 76.3MB)
테스트 17 〉	통과 (3.05ms, 69.3MB)
테스트 18 〉	통과 (2.01ms, 80.3MB)
테스트 19 〉	통과 (3.19ms, 93.6MB)
테스트 20 〉	통과 (1.98ms, 81.1MB)
테스트 21 〉	통과 (2.51ms, 77MB)
테스트 22 〉	통과 (2.20ms, 79.9MB)
테스트 23 〉	통과 (0.45ms, 75MB)
테스트 24 〉	통과 (0.46ms, 78MB)
테스트 25 〉	통과 (0.29ms, 72.8MB)
테스트 26 〉	통과 (0.60ms, 74.1MB)
테스트 27 〉	통과 (0.30ms, 75.4MB)
테스트 28 〉	통과 (0.49ms, 75.6MB)
테스트 29 〉	통과 (0.45ms, 70.7MB)
테스트 30 〉	통과 (0.35ms, 77.5MB)
효율성  테스트
테스트 1 〉	통과 (178.84ms, 134MB)
테스트 2 〉	통과 (178.93ms, 134MB)
테스트 3 〉	통과 (187.15ms, 146MB)
테스트 4 〉	통과 (184.39ms, 134MB)
테스트 5 〉	통과 (189.09ms, 130MB)
테스트 6 〉	통과 (221.37ms, 131MB)
테스트 7 〉	통과 (138.07ms, 102MB)
테스트 8 〉	통과 (106.73ms, 114MB)
테스트 9 〉	통과 (199.10ms, 130MB)
테스트 10 〉	통과 (214.10ms, 135MB)
 */
