// Design HashMap
package leetcode.explore.hashTable;

import java.util.ArrayList;
import java.util.List;

public class HashTable2 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        print(myHashMap);

        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        print(myHashMap);

        System.out.println("myHashMap.get(1) = " + myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println("myHashMap.get(3) = " + myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]

        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        print(myHashMap);

        System.out.println("myHashMap.get(2) = " + myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]

        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        print(myHashMap);

        System.out.println("myHashMap.get(2) = " + myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }

    private static void print(MyHashMap myHashMap) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < myHashMap.map.size(); i++) {
            sb.append('[');
            sb.append(myHashMap.map.get(i)[0]);
            sb.append(',');
            sb.append(myHashMap.map.get(i)[1]);
            sb.append("], ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        System.out.println(sb);
    }

    static class MyHashMap {
        List<int[]> map;

        public MyHashMap() {
            map = new ArrayList<>();
        }

        public void put(int key, int value) {
            if (get(key) == -1) {
                map.add(new int[]{key, value});
                return;
            }

            for (int i = 0; i < map.size(); i++) {
                if (map.get(i)[0] == key) {
                    map.get(i)[1] = value;
                    return;
                }
            }
        }

        public int get(int key) {
            for (int i = 0; i < map.size(); i++) {
                if (map.get(i)[0] == key) {
                    return map.get(i)[1];
                }
            }
            return -1;
        }

        public void remove(int key) {
            for (int i = 0; i < map.size(); i++) {
                if (map.get(i)[0] == key) {
                    map.remove(i);
                    break;
                }
            }
        }
    }
}
