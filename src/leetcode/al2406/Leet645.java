package leetcode.al2406;

/**
 Easy
 645. Set Mismatch

 정수 집합 s가 있습니다.
 이 집합은 원래 1부터 n까지의 모든 숫자를 포함하고 있습니다.
 하지만 어떤 오류로 인해 이 집합의 숫자 중 하나가 다른 숫자로 중복되어,
 하나의 숫자가 반복되고 다른 하나의 숫자가 사라지게 되었습니다.

 당신에게 이 오류 후 집합의 데이터 상태를 나타내는 정수 배열 nums가 주어집니다.

 중복된 숫자와 누락된 숫자를 찾아 배열 형태로 반환하세요.
 */
public class Leet645 {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int[] res = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) {
                res[1] = i;
                continue;
            }
            if (count[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}
