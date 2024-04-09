package leetcode.al2404;

public class Leet2073 {
    public static void main(String[] args) {
        Leet2073 l = new Leet2073();

        int[] tickets1 = {2, 3, 2};
        int[] tickets2 = {5, 1, 1, 1};

        System.out.println(l.timeRequiredToBuy(tickets1, 2));
        System.out.println(l.timeRequiredToBuy(tickets2, 0));
    }

    // 내 풀이
    public int timeRequiredToBuy(int[] tickets, int k) {
        int answer = 0;
        int flag = tickets[k];
        for (int i = 0; i <= k - 1; i++) {
            answer += Math.min(tickets[i], flag);
        }
        answer += flag;
        for (int i = k + 1; i < tickets.length; i++) {
            answer += Math.min(tickets[i], flag - 1);
        }
        return answer;
    }
}
