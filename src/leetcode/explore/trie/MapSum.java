package leetcode.explore.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int answer = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                answer += map.get(key);
            }
        }
        return answer;
    }
}
