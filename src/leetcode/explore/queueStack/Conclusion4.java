package leetcode.explore.queueStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Conclusion4 {
    public static void main(String[] args) {
        Conclusion4 c = new Conclusion4();

        List<List<Integer>> rooms1 = new ArrayList<>();
        List<Integer> r1_1 = new ArrayList<>();
        r1_1.add(1);
        List<Integer> r1_2 = new ArrayList<>();
        r1_2.add(2);
        List<Integer> r1_3 = new ArrayList<>();
        r1_3.add(3);
        List<Integer> r1_4 = new ArrayList<>();
        rooms1.add(r1_1);
        rooms1.add(r1_2);
        rooms1.add(r1_3);
        rooms1.add(r1_4);

        List<List<Integer>> rooms2 = new ArrayList<>();
        List<Integer> r2_1 = new ArrayList<>();
        r2_1.add(1);
        r2_1.add(3);
        List<Integer> r2_2 = new ArrayList<>();
        r2_2.add(3);
        r2_2.add(0);
        r2_2.add(1);
        List<Integer> r2_3 = new ArrayList<>();
        r2_3.add(2);
        List<Integer> r2_4 = new ArrayList<>();
        r2_4.add(0);
        rooms2.add(r2_1);
        rooms2.add(r2_2);
        rooms2.add(r2_3);
        rooms2.add(r2_4);

        System.out.println(c.canVisitAllRooms(rooms1));
        System.out.println(c.canVisitAllRooms(rooms2));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int roomNum = queue.peek();
                visited[roomNum] = true;
                List<Integer> keysInRoom = rooms.get(roomNum);
                for (int j = 0; j < keysInRoom.size(); j++) {
                    if (visited[keysInRoom.get(j)]) {
                        continue;
                    }
                    queue.add(keysInRoom.get(j));
                }
                queue.poll();
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
