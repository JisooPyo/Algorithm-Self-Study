package leetcode.al2406;

/**
 * Medium
 * 1052. Grumpy Bookstore Owner
 *
 * n분동안 여는 가게를 가지고 있는 서점 주인이 있다.
 * 매 분마다, 몇몇 손님이 가게로 들어온다.
 *
 *  customers : 길이 n의 정수 배열
 *             customers[i]는 i번째 분의 시작에 가게에 들어가는 손님 수이다.
 *             그리고 모든 손님은 그 분이 끝나면 떠난다.
 *
 * 몇몇 분에서 서점 주인은 성격이 나빠진다.
 *
 * grumpy : 만약, 서점 주인이 i번째 분동안 성격이 나빠진다면 grumpy[i]는 1이다. 아니면 0.
 *
 * 서점 주인이 성격이 나빠질 때 그 분에 있었던 손님들은 만족스럽지 않다. 그렇지 않다면 만족스러워 한다.
 * 서점 주인은 "minute"동안 성격이 나빠지지 않는 비밀 테크닉을 알고 있고 단 한 번 사용할 수 있다.
 *
 * 하루동안 만족스러워할 수 있는 최대 손님 수를 구하여라.
 */
public class Leet1052 {
    public static void main(String[] args) {
        Leet1052 l = new Leet1052();
        int[] customers1 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1 = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes1 = 3;

        int[] customers2 = {1};
        int[] grumpy2 = {0};
        int minutes2 = 1;

        int[] customers3 = {4, 10, 10};
        int[] grumpy3 = {1, 1, 0};
        int minutes3 = 2;
        System.out.println(l.maxSatisfied(customers1, grumpy1, minutes1));  // 16
        System.out.println(l.maxSatisfied(customers2, grumpy2, minutes2));  // 1
        System.out.println(l.maxSatisfied(customers3, grumpy3, minutes3));  // 24
    }

    // 내 풀이 : 3ms
    // 걸린 시간 : 15m
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 이미 만족하는 손님들
        int satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        // 첫번째에서 비밀기술을 썼을 때 값 구하기
        int maxSecret = 0;
        int secret = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                secret += customers[i];
            }
        }
        maxSecret = secret;

        // 비밀기술 썼을 때 max 값 구하기
        for (int i = 1; i <= customers.length - minutes; i++) {
            if (grumpy[i + minutes - 1] == 1) {
                secret += customers[i + minutes - 1];
            }
            if (grumpy[i - 1] == 1) {
                secret -= customers[i - 1];
            }
            maxSecret = Math.max(secret, maxSecret);
        }
        return satisfied + maxSecret;
    }

    // 다른 사람의 풀이
    // grumpy[i]는 1 아니면 0이므로 조건문이 아니라 곱하기 연산을 통하여 max 값을 구할 수 있다.
}
