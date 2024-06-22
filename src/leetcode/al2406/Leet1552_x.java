package leetcode.al2406;

import java.util.Arrays;

/**
 Medium
 1552. Magnetic Force Between Two Balls

 지구 C-137의 우주에서, Rick 은 그가 새로 발명한 바구니 안에 있는 두 공 사이에 아주 특별한 형태의 자기력을 발견했다.
 Rick 은 n개의 빈 바구니를 가지고 있다. i번째 바구니는 position[i]에 있다.
 Morty 는 m개의 공을 가지고 있고, 두 볼 사이 최소 자기력이 최대가 되도록 바구니에 공을 분배해야 한다.
 Rick 은 position x와 y에 있는 두 볼 사이의 자기력을 |x - y| 로 정의했다.

 Given
 position : 정수 배열
 m : 정수

 Return
 두 볼 사이에 최소 자기력을 구하여라.(최소 자기력이 최대가 되는)
 */

public class Leet1552_x {
    public static void main(String[] args) {
        Leet1552_x l = new Leet1552_x();

        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;

        System.out.println(l.maxDistance(position1, m1));   // 3
        System.out.println(l.maxDistance(position2, m2));   // 999999999
    }

    // 내 풀이
    // 풀다 보니까 바구니가 띄엄띄엄 있을 때를 구하고 있는 것이 아니라
    // 바구니가 연속적으로 있을 때를 구하고 있었다.
    // (max - min + 1) / (m - 1) 까지 구현..
    // 띄엄띄엄 있을 때는 감을 잘 못 잡겠어서 힌트를 봤더니 이진 검색. 알 듯 말 듯 잘 감이 안 잡혀서
    // 결국 다른 사람 풀이 참고

    // 다른 사람 풀이 : 34ms
    // 시간복잡도 O(N Log N)
    public int maxDistance(int[] position, int m) {
        // 정렬
        Arrays.sort(position);

        // 다 차 있다고 생각하면 end 에 공이 들어가야 하는데 end 에 바구니가 있는지 없는지 모름.
        // start ~ end 어딘가에 공이 들어가게 되고 그 때의 start와 end 사이가 답이 되는 것.
        int start = 1;
        int end = (position[position.length - 1] - position[0]) / (m - 1);
        while (start <= end) {
            int mid = (end + start) / 2;
            int req = dist(position, mid);
            if (req >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    // mid 거리로 공을 배치했을 때 필요한 공의 개수
    public int dist(int[] nums, int mid) {
        int count = 1;  // 초기 공의 갯수
        int last = nums[0];     // 첫번째 공의 위치
        // 현재 공의 위치와 마지막 공의 위치 차이가 mid 이상이면 공 배치, 공 개수 증가
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= mid) {
                count++;
                last = nums[i];
            }
        }
        return count;
    }
}
