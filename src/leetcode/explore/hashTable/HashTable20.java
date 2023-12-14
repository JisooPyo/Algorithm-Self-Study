package leetcode.explore.hashTable;

import java.util.*;

public class HashTable20 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println("randomizedSet.insert(1) = " + randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.set);

        System.out.println("randomizedSet.remove(2) = " + randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.set);

        System.out.println("randomizedSet.insert(2) = " + randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.set);

        System.out.println("randomizedSet.getRandom() = " + randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.

        System.out.println("randomizedSet.remove(1) = " + randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.set);

        System.out.println("randomizedSet.insert(2) = " + randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.set);

        System.out.println("randomizedSet.getRandom() = " + randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }

    static class RandomizedSet {
        Set<Integer> set;

        public RandomizedSet() {
            set = new HashSet<>();
        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            List<Integer> list = new ArrayList<>(set);
            Random random = new Random();
            int randomIndex = random.nextInt(list.size());
            return list.get(randomIndex);
        }
    }
}
