package leetcode.al2407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hard
 * 2751. Robot Collisions
 *
 * n개의 로봇이 있으며, 각 로봇은 선상에 위치, 체력, 이동 방향을 가지고 있습니다.
 * 0부터 시작하는 정수 배열 positions, healths, 그리고 문자열 directions 가 주어집니다
 * directions[i]는 'L' (왼쪽) 또는 'R' (오른쪽) 중 하나입니다.
 * positions 의 모든 정수는 고유합니다.
 *
 * 모든 로봇은 주어진 방향으로 동일한 속도로 동시에 움직이기 시작합니다.
 * 이동 중에 두 로봇이 동일한 위치를 차지하게 되면, 그들은 충돌하게 됩니다.
 *
 * 두 로봇이 충돌하면, 체력이 더 낮은 로봇이 선에서 제거되고, 다른 로봇의 체력은 1 감소합니다.
 * 살아남은 로봇은 원래 가던 방향으로 계속 이동합니다. 두 로봇의 체력이 같다면, 둘 다 선에서 제거됩니다.
 *
 * 여러분의 과제는 충돌 후 생존한 로봇들의 체력을, 로봇들이 주어진 순서대로 결정하는 것입니다.
 * 즉, 로봇 1의 최종 체력(생존한 경우), 로봇 2의 최종 체력(생존한 경우) 등을 순서대로 나열해야 합니다.
 * 생존자가 없다면 빈 배열을 반환합니다.
 *
 *  충돌이 더 이상 발생할 수 없을 때 남아있는 로봇들의 체력을 포함하는 배열을 반환하세요(입력된 순서대로).
 *
 * 주의: positions 는 정렬되지 않을 수 있습니다.
 */
public class Leet2751_x {
    public static void main(String[] args) {
        Leet2751_x l = new Leet2751_x();
        int[] positions1 = {5, 4, 3, 2, 1};
        int[] healths1 = {2, 17, 9, 15, 10};
        String directions1 = "RRRRR";

        int[] positions2 = {3, 5, 2, 6};
        int[] healths2 = {10, 10, 15, 12};
        String directions2 = "RLRL";

        int[] positions3 = {1, 2, 5, 6};
        int[] healths3 = {10, 10, 11, 11};
        String directions3 = "RLRL";
        System.out.println(l.survivedRobotsHealths(positions1, healths1, directions1));     // [2,17,9,15,10]
        System.out.println(l.survivedRobotsHealths(positions2, healths2, directions2));     // [14]
        System.out.println(l.survivedRobotsHealths(positions3, healths3, directions3));     // []

    }

    // 다른 사람의 풀이 : 29ms
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        Robot[] robots = new Robot[positions.length];
        List<Robot> stack = new ArrayList<>(); // running robots

        for (int i = 0; i < positions.length; ++i)
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));

        Arrays.sort(robots, (a, b) -> a.position - b.position);


        for (Robot robot : robots) {
            // 로봇의 방향이 R이면 stack에 저장
            if (robot.direction == 'R') {
                stack.add(robot);
                continue;
            }
            // Collide with robots going right if any.
            // 현재 로봇의 방향이 왼쪽이고, stack의 제일 바깥에 있는 로봇이 오른쪽으로 움직일 때
            while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
                if (stack.get(stack.size() - 1).health == robot.health) {
                    stack.remove(stack.size() - 1);
                    robot.health = 0;
                } else if (stack.get(stack.size() - 1).health < robot.health) {
                    stack.remove(stack.size() - 1);
                    robot.health -= 1;
                } else { // stack[-1].health > robot.health
                    stack.get(stack.size() - 1).health -= 1;
                    robot.health = 0;
                }
            }
            if (robot.health > 0)
                stack.add(robot);
        }

        stack.sort((a, b) -> a.index - b.index);

        for (Robot robot : stack)
            ans.add(robot.health);

        return ans;
    }

    class Robot {
        public int index;
        public int position;
        public int health;
        public char direction;

        public Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }
}
