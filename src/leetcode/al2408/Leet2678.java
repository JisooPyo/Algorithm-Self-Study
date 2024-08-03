package leetcode.al2408;

/**
 * Easy
 * 2678. Number of Senior Citizens
 *
 * 0-indexed인 문자열 배열 details 가 주어진다.
 * details의 각 원소는 주어진 승객에 대한 정보 길이 15의 압축된 문자열 를 제공한다.
 *
 * 정보는 이런 특성을 가진다.
 *   - 첫 10자는 승객의 전화번호이다.
 *   - 다음 문자는 승객의 성별을 나타낸다.
 *   - 다음 두 글자는 승객의 나이를 나타낸다.
 *   - 마지막 두 글자는 승객에게 할당된 좌석을 나타낸다.
 *
 * 60살보다 많은 나이의 승객의 수를 구하라.
 */
public class Leet2678 {
    public static void main(String[] args) {
        Leet2678 leet2678 = new Leet2678();
        String[] details1 = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        String[] details2 = {"1313579440F2036", "2921522980M5644"};
        System.out.println(leet2678.countSeniors(details1));    // 2
        System.out.println(leet2678.countSeniors(details2));    // 0

    }

    // 내 풀이: 0ms
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            char ten = detail.charAt(11);
            if (ten - '0' < 6) {
                continue;
            }
            if (ten - '0' > 6) {
                count++;
                continue;
            }
            if (detail.charAt(12) != '0') {
                count++;
            }
        }
        return count;
    }
}
