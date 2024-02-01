package leetcode.explore.recursion;

import java.util.HashMap;
import java.util.Map;

public class Rec7 {
    public static void main(String[] args) {
        Rec7 r = new Rec7();
        System.out.println(r.climbStairs(2));
        System.out.println(r.climbStairs(3));
        System.out.println(r.climbStairs(4));
        System.out.println(r.climbStairs(5));
        System.out.println(r.climbStairs(6));
        System.out.println(r.climbStairs(7));
        System.out.println(r.climbStairs(8));
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            map.put(0, 1);
            return 1;
        }
        if (n == 1) {
            map.put(1, 1);
            return 1;
        }
        int answer = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, answer);
        return answer;
    }
}
