package leetcode.al2407;

/**
 * Easy
 * 1025. Divisor Game
 *
 * Alice와 Bob이 차례대로 게임을 진행합니다. Alice가 먼저 시작합니다.
 *
 * 처음에는 칠판에 숫자 `n`이 적혀 있습니다. 각 플레이어의 턴마다 다음과 같은 움직임을 수행합니다:
 *
 * 0 < x < n이고 n % x == 0을 만족하는 임의의 x를 선택합니다.
 * 칠판에 적힌 숫자 n을 n - x로 교체합니다.
 * 또한, 플레이어가 움직임을 수행할 수 없으면 그 플레이어는 게임에서 패배합니다.
 *
 * Alice가 게임을 이기면 true를, 그렇지 않으면 false를 반환하세요. 두 플레이어 모두 최적의 플레이를 한다고 가정합니다.
 */
public class Leet1025 {
    public static void main(String[] args) {
        Leet1025 l = new Leet1025();

        System.out.println(l.divisorGame(2));   // true
        System.out.println(l.divisorGame(3));   // false
        System.out.println(l.divisorGame(4));   // true
        System.out.println(l.divisorGame(5));   // false
    }

    // 내 풀이: 0ms
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
