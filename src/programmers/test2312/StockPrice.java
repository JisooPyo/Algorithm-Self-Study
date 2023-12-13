package programmers.test2312;

import java.util.Arrays;
import java.util.PriorityQueue;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices1 = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices1)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time = 0;
        answer[answer.length - 1] = time;

        PriorityQueue<Integer> storePrice = new PriorityQueue<>();
        storePrice.add(prices[prices.length - 1]);

        for (int i = prices.length - 2; i >= 0; i--) {
            time++;
            if (storePrice.peek() >= prices[i]) {
                answer[i] = time;
                storePrice.add(prices[i]);
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
            storePrice.add(prices[i]);
        }

        return answer;
    }
}
