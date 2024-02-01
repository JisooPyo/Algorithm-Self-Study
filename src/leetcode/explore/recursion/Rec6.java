package leetcode.explore.recursion;

import java.util.HashMap;
import java.util.Map;

public class Rec6 {
    public static void main(String[] args) {
        Rec6 r = new Rec6();
        System.out.println(r.fib(2));
        System.out.println(r.fib(3));
        System.out.println(r.fib(4));
        System.out.println(r.fib(5));
        System.out.println(r.fib(6));
        System.out.println(r.fib(7));
        System.out.println(r.fib(8));
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            map.put(0, 0);
            return 0;
        }
        if (n == 1) {
            map.put(1, 1);
            return 1;
        }
        int answer = fib(n - 1) + fib(n - 2);
        map.put(n, answer);
        return answer;
    }
}
