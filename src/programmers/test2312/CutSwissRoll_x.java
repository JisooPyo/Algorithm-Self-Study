package programmers.test2312;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CutSwissRoll_x {
    public static void main(String[] args) {
        CutSwissRoll_x c = new CutSwissRoll_x();

        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1, 2, 3, 1, 4};

        System.out.println(c.solution(topping1));   // 2
        System.out.println(c.solution(topping2));   // 0
    }

    // 1 <= 토핑의 길이 <= 1,000,000
    // 1 <= 토핑의 원소 <= 10,000
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }
            if (set.size() == map.size()) {
                answer++;
            }

        }

        return answer;
    }
}

