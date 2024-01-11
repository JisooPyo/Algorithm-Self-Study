package programmers.test2401;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ConvertNumbers {
    public static void main(String[] args) {
        ConvertNumbers c = new ConvertNumbers();
        System.out.println(c.solution(10, 40, 5));  // 2
        System.out.println(c.solution(10, 40, 30)); // 1
        System.out.println(c.solution(2, 5, 4));    // -1
    }

    public int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(x);
        set.add(x);
        loop1:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int peek = queue.peek();
                if (peek == y) {
                    break loop1;
                }
                if (!set.contains(peek + n) && peek + n <= y) {
                    set.add(peek + n);
                    queue.add(peek + n);
                }
                if (!set.contains(peek * 2) && peek * 2 <= y) {
                    set.add(peek * 2);
                    queue.add(peek * 2);
                }
                if (!set.contains(peek * 3) && peek * 3 <= y) {
                    set.add(peek * 3);
                    queue.add(peek * 3);
                }
                queue.poll();
            }
            count++;
        }
        return queue.isEmpty() ? -1 : count;
    }
}

// 재귀로 풀이
// 시간 초과 발생
// map으로 dp 풀이
// -> 7, 9, 10, 11, 14: 런타임에러
// => 함수 호출 횟수가 정해져 있어 런타임 에러 발생

// while, queue로 문제 풀이
// 5, 7, 9, 10, 11: 시간초과
// set으로 dp
// 통과