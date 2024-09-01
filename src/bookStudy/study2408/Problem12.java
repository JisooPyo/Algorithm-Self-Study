package bookStudy.study2408;

import java.util.Arrays;
import java.util.Stack;

/**
 * 프로그래머스 lv.2
 * 12. 주식 가격
 */
public class Problem12 {
    public static void main(String[] args) {
        Problem12 p = new Problem12();
        int[] prices1 = {1, 2, 3, 2, 3};
        int[] prices2 = {1, 2, 3, 2, 3, 4, 5, 3, 2, 1};

        // [4, 3, 1, 1, 0]
        System.out.println(Arrays.toString(p.solution(prices1)));
        // [9, 8, 1, 6, 4, 2, 1, 1, 1, 0]
        System.out.println(Arrays.toString(p.solution(prices2)));
    }

    // 셀프 피드백: Element class를 선언하지 않고, index만 스택으로 했어도 prices[index]로써
    // 값을 가지고 올 수 있었다!!
    public int[] solution(int[] prices) {
        int n = prices.length;
        Stack<Element> stack = new Stack<>();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().value > prices[i]) {
                Element e = stack.pop();
                answer[e.index] = i - e.index;
            }
            stack.push(new Element(i, prices[i]));
        }

        while (!stack.isEmpty()) {
            Element e = stack.pop();
            answer[e.index] = n - 1 - e.index;
        }

        return answer;
    }

    class Element {
        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.30ms, 75.4MB)
테스트 2 〉	통과 (0.50ms, 76.3MB)
테스트 3 〉	통과 (1.10ms, 73.9MB)
테스트 4 〉	통과 (1.28ms, 77MB)
테스트 5 〉	통과 (1.31ms, 81MB)
테스트 6 〉	통과 (0.37ms, 66.8MB)
테스트 7 〉	통과 (1.19ms, 78.7MB)
테스트 8 〉	통과 (1.68ms, 74.2MB)
테스트 9 〉	통과 (0.47ms, 78.8MB)
테스트 10 〉	통과 (1.54ms, 79.2MB)

효율성  테스트
테스트 1 〉	통과 (29.80ms, 71.9MB)
테스트 2 〉	통과 (23.33ms, 70MB)
테스트 3 〉	통과 (33.76ms, 75.7MB)
테스트 4 〉	통과 (28.50ms, 71.9MB)
테스트 5 〉	통과 (23.48ms, 67.7MB)
 */
