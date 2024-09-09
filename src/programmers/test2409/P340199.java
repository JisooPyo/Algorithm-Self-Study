package programmers.test2409;

/**
 * 프로그래머스 lv.1
 * [PCCE 기출문제] 9번 / 지폐 접기
 */
public class P340199 {
    public static void main(String[] args) {
        P340199 p = new P340199();

        int[] wallet1 = {30, 15};
        int[] bill1 = {26, 17};

        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};

        System.out.println(p.solution(wallet1, bill1));     // 1
        System.out.println(p.solution(wallet2, bill2));     // 4
    }

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            if ((bill[0] <= wallet[0] && bill[1] <= wallet[1])
                || (bill[1] <= wallet[0] && bill[0] <= wallet[1])) {
                break;
            }
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}
