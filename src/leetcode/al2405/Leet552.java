package leetcode.al2405;

/**
 * 552. Student Attendance Record II(Hard)
 *
 * 학생의 출결 기록은 결석은 'A'(Absent), 지각은 'L'(Late), 출석은 'P'(Present)로 나타낸다.
 * 다음 두 저건을 만족하는 학생은 출석 보상을 받는다.
 * 1. 전체 결석일수가 2일 미만(1일 이하)이다.
 * 2. 지각은 연달아 3번 이상 할 수 없다.
 *
 * Given
 * n: 정수
 *
 * Return
 * 출석 보상을 받는 가능한 출결 기록의 수를 반환하라.
 * 답이 너무 크다면 mod 10^9+7의 값을 반환하라.
 */
public class Leet552 {
    public static void main(String[] args) {
        Leet552 l = new Leet552();
        // "A", "P", "L"
        // System.out.println(l.checkRecord(1));   // 3
        // "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
        // System.out.println(l.checkRecord(2));   // 8
        // System.out.println(l.checkRecord(3));   // 19
        System.out.println(l.checkRecord(4));   // 43
        System.out.println(l.checkRecord(5));   // 94
        System.out.println(l.checkRecord(10101));   // 183236316
    }

    // 내 풀이
    // checkRecord(n) = (i=0 ~ n-1) ∑( whenAllPresent(i) * whenAllPresent(n-1-i) )  // 결석 하루 했을 때
    //                  + whenAllPresent(n)         // 결석을 한 번도 하지 않았을 때
    // whenAllPresent(n) = whenAllPresent(n-1) + whenAllPresent(n-2) + whenAllPresent(n-3)
    //                     P[...]                LP[...]               LLP[...]
    // whenAllPresent(1) = 2
    // whenAllPresent(2) = 4
    // whenAllPresent(3) = 7
    public int checkRecord(int n) {
        long mod = 1_000_000_007L;
        if (n == 1) {
            return 3;
        }
        long[] whenAllPresent = new long[n + 1];
        whenAllPresent[0] = 1;
        if (n >= 1) {
            whenAllPresent[1] = 2;
        }
        if (n >= 2) {
            whenAllPresent[2] = 4;
        }
        if (n >= 3) {
            whenAllPresent[3] = 7;
        }
        for (int i = 4; i <= n; i++) {
            whenAllPresent[i] =
                (whenAllPresent[i - 1] + whenAllPresent[i - 2] + whenAllPresent[i - 3]) % mod;
        }
        long zeroAbsent = whenAllPresent[n];
        long oneAbsent = 0;
        for (int i = 0; i < n; i++) {
            oneAbsent += (whenAllPresent[i] * whenAllPresent[n - 1 - i]) % mod;
            oneAbsent %= mod;
        }
        long ans = (zeroAbsent + oneAbsent) % mod;
        return (int)ans;
    }

}
