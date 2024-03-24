package leetcode.al2403;

public class Leet287 {

    // 처음에 Set으로 푸니 생각보다 오래 걸려서 int 배열로 다시 풀었다.
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] != 0) {
                return nums[i];
            }
            count[nums[i]]++;
        }
        return 0;
    }

    // 다른 사람의 풀이
    // boolean 배열로 풀어 조금 더 빨랐다.
}
