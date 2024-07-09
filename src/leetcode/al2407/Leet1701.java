package leetcode.al2407;

/**
 * Medium
 * 1701. Average Waiting Time
 *
 * 한 명의 셰프가 있는 식당이 있다.
 * customers[i] = [arrival_i, time_i]인 customers 배열이 주어진다.
 *
 *  - arrival_i는 i번째 손님의 도착 시간이다. 도착 시간은 감소하지 않는 순서로 정렬되어 있다.
 *  - time_i는 i번째 손님의 주문을 준비하는 데 필요한 시간이다.
 *
 * 손님이 도착했을 때, 손님은 셰프에게 주문한다. 셰프는 게을러서 그제서야 주문 준비를 시작한다.
 * 손님은 셰프가 그의 주문을 끝낼 때까지 기다린다.
 * 셰프는 한 번에 한 주문만 처리한다.
 * 셰프는 input 에서 주어진 순서대로 손님들의 음식을 준비한다.
 *
 * 모든 손님의 평균 웨이팅 시간을 구하여라.
 * (실제 답변에서 (10^-5) 이내의 솔루션은 허용되는 것으로 간주된다.)
 */
public class Leet1701 {
    public static void main(String[] args) {
        Leet1701 l = new Leet1701();

        int[][] customers1 = {{1, 2}, {2, 5}, {4, 3}};
        int[][] customers2 = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};

        System.out.println(l.averageWaitingTime(customers1));   // 5
        System.out.println(l.averageWaitingTime(customers2));   // 3.25
    }

    // 내 풀이 : 3ms
    public double averageWaitingTime(int[][] customers) {
        int cur = customers[0][0];
        long total = 0;
        for (int i = 0; i < customers.length; i++) {
            cur = Math.max(customers[i][0], cur);
            cur += customers[i][1];
            total += (cur - customers[i][0]);
            System.out.println("(cur - customers[i][0]) = " + (cur - customers[i][0]));
        }
        return (double)total / customers.length;
    }
}
