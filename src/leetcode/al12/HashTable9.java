package leetcode.al12;

import java.util.*;

public class HashTable9 {
    public static void main(String[] args) {
        String[] list1_1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2_1 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] list1_2 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2_2 = {"KFC", "Shogun", "Burger King"};

        String[] list1_3 = {"happy", "sad", "good"};
        String[] list2_3 = {"sad", "happy", "good"};

        System.out.println(Arrays.toString(findRestaurant(list1_1, list2_1)));  // {"Shogun"}
        System.out.println(Arrays.toString(findRestaurant(list1_2, list2_2)));  // {"Shogun"}
        System.out.println(Arrays.toString(findRestaurant(list1_3, list2_3)));  // {"sad","happy"}
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list1StringIndex = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            list1StringIndex.put(list1[i], i);
        }

        Map<String, Integer> commonStringIndexSum = new HashMap<>();
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (list1StringIndex.containsKey(list2[i])) {
                commonStringIndexSum.put(list2[i], list1StringIndex.get(list2[i]) + i);
                minimum = Math.min(commonStringIndexSum.get(list2[i]), minimum);
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String key : commonStringIndexSum.keySet()) {
            if (commonStringIndexSum.get(key) == minimum) {
                answerList.add(key);
            }
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
