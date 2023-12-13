package leetcode.explore.hashTable;

public class HashTable1 {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(9);
        myHashSet.remove(19);
        myHashSet.add(14);
        myHashSet.remove(19);
        myHashSet.remove(9);
        myHashSet.add(0);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(0);
        myHashSet.remove(9);
    }

    static class MyHashSet {
        int[] set;

        public MyHashSet() {
            set = new int[0];
        }

        public void add(int key) {
            if (contains(key)) {
                return;
            }
            int[] newSet = new int[set.length + 1];
            System.arraycopy(set, 0, newSet, 0, set.length);
            newSet[newSet.length - 1] = key;
            set = newSet;
        }

        public void remove(int key) {
            if (!contains(key)) {
                return;
            }
            if (set.length == 1) {
                set = new int[0];
            }
            int index = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] == key) {
                    index = i;
                    break;
                }
            }
            int[] newSet = new int[set.length - 1];
            if (index >= 1) {
                System.arraycopy(set, 0, newSet, 0, index);
            }
            if (index != set.length - 1) {
                System.arraycopy(set, index + 1, newSet, index, set.length - index - 1);
            }
            set = newSet;
        }

        public boolean contains(int key) {
            for (int i = 0; i < set.length; i++) {
                if (set[i] == key) {
                    return true;
                }
            }
            return false;
        }
    }
}
