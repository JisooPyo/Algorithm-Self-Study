package leetcode.al2403;

import java.util.ArrayList;
import java.util.List;

public class Leet442 {
    public static void main(String[] args) {
        Leet442 l = new Leet442();

        System.out.println(l.findDuplicates(new int[]{4, -3, -2, -7, 8, 2, -3, -1}));
    }

    // 내 풀이
    // 문제 요구사항
    // 추가 공간은 상수만큼만 허용 -> 어긋남
    // 시간 복잡도는 O(n) -> 지킴
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                list.add(i);
            }
        }
        return list;
    }

    // 다른 사람의 풀이
    // 어차피 최대 count는 2이고 각 원소의 값은 양수이므로
    // 각 원소를 index로 생각해서 한 번 나왔던 것은 -로 check.
    // 나중에 확인했을 때 -인 것만 list에 추가하면 된다.
    public List<Integer> findDuplicatesOther(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int n: nums) {
            if(nums[Math.abs(n) - 1] < 0) {
                result.add(Math.abs(n));
            }else {
                nums[Math.abs(n) - 1] *= -1;
            }
        }
        return result;
    }
}
