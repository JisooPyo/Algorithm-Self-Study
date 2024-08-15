package leetcode.al2408;

/**
 * Easy
 * 860. Lemonade Change
 *
 * 레모네이드 스탠드에서 각 레모네이드의 비용은 5달러이다.
 * 손님들은 레모네이드를 사기 위해 큐에 서 있다.
 * 지불할 때에는 5달러, 10달러, 20달러 지폐로 낸다.
 * 손님이 5달러만 내게끔 각 손님에게 올바른 거스름돈을 돌려주어야 한다.
 *
 * 처음에는 잔돈을 가지고 있지 않다.
 *
 * 정수 배열 bills가 주어지고, bills[i]는 i번째 손님이 지불하는 지폐이다.
 * 만약 모든 손님에게 올바른 잔돈을 제공할 수 있다면 true, 아니면 false를 return하라.
 */
public class Leet860 {
    public static void main(String[] args) {
        Leet860 leet860 = new Leet860();
        int[] bills1 = {5, 5, 5, 10, 20};
        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println(leet860.lemonadeChange(bills1));     // true
        System.out.println(leet860.lemonadeChange(bills2));     // false
    }

    int[] myBills;

    // 내 풀이: 3ms
    public boolean lemonadeChange(int[] bills) {
        myBills = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                myBills[0]++;
                continue;
            }
            if (bills[i] == 10) {
                myBills[1]++;
            }
            if (!checkCanProvideChange(bills[i] - 5)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCanProvideChange(int targetChange) {
        if (targetChange == 5) {
            if (myBills[0] > 0) {
                myBills[0]--;
                return true;
            } else {
                return false;
            }
        } else {        // targetChange == 15
            if (myBills[1] >= 1 && myBills[0] >= 1) {
                myBills[1]--;
                myBills[0]--;
                return true;
            } else if (myBills[0] >= 3) {
                myBills[0] -= 3;
                return true;
            } else {
                return false;
            }
        }
    }
}
