package leetcode.al2407;

/**
 * Easy
 * 1518. Water Bottles
 *
 * 처음에 물이 가득 차 있는 물병 numBottles 가 있다.
 * numExchange 만큼의 빈 물병을 하나의 가득 찬 물 한 병으로 바꿀 수 있다.
 * 두 정수 numBottles, numExchange 가 주어집니다. 마실 수 있는 최대 물병 수를 구하세요.
 */
public class Leet1518 {
    public static void main(String[] args) {
        Leet1518 l = new Leet1518();

        System.out.println(l.numWaterBottles(9, 3));    // 13
        System.out.println(l.numWaterBottles(15, 4));   // 19
    }

    // 내 풀이 : 0ms
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int cur = numBottles;
        while (cur >= numExchange) {
            ans += cur / numExchange;
            cur = cur / numExchange + cur % numExchange;
        }
        return ans;
    }
}
