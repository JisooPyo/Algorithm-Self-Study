package leetcode.al2407;

/**
 * Easy
 * 1598. Crawler Log Folder
 *
 * 리트코드 파일 시스템은 몇 명의 유저가 폴더 연산 변화를 수행할 때마다 로그를 유지합니다.
 * 연산은 아래와 같이 정의됩니다.
 *   - "../" : 현재 폴더의 부모 폴더로 이동합니다. (만약, 이미 main 폴더에 남아 있다면 같은 폴더에 남아 있습니다.)
 *   - "./" : 같은 폴더에 남아있습니다.
 *   - "x/" : x 라는 이름의 자식 폴더로 이동합니다. (이 폴더는 항상 존재한다고 보증합니다.)
 *
 * 문자열 리스트 logs 가 주어집니다.
 *   - logs[i]는 i번째 스텝에서 유저에게 행해진 연산입니다.
 *
 * 파일 시스템은 메인 폴더에서 시작하고, logs의 연산이 행해집니다.
 *
 * 폴더 연산 변화 후에 메인 폴더로 돌아가기 위해 필요한 연산의 최소 수를 구하시오.
 */
public class Leet1598 {
    public static void main(String[] args) {
        Leet1598 l = new Leet1598();
        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        String[] logs2 = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        String[] logs3 = {"d1/", "../", "../", "../"};
        System.out.println(l.minOperations(logs1)); // 2
        System.out.println(l.minOperations(logs2)); // 3
        System.out.println(l.minOperations(logs3)); // 0
    }

    // 내 풀이 : 1ms
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            switch (log) {
                case "./":
                    continue;
                case "../":
                    if (ans > 0) {
                        ans--;
                    }
                    break;
                default:
                    ans++;
            }
        }
        return ans;
    }
}
