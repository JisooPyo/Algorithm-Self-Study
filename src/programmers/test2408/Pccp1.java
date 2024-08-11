package programmers.test2408;

public class Pccp1 {
    public static void main(String[] args) {
        Pccp1 p = new Pccp1();

        int[] bandage1 = {5, 1, 5};
        int[][] attacks1 = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int[] bandage2 = {3, 2, 7};
        int[][] attacks2 = {{1, 15}, {5, 16}, {8, 6}};
        int[] bandage3 = {4, 2, 7};
        int[][] attacks3 = {{1, 15}, {5, 16}, {8, 6}};
        int[] bandage4 = {1, 1, 1};
        int[][] attacks4 = {{1, 2}, {3, 2}};

        System.out.println(p.solution(bandage1, 30, attacks1));     // 5
        System.out.println(p.solution(bandage2, 20, attacks2));     // -1
        System.out.println(p.solution(bandage3, 20, attacks3));     // -1
        System.out.println(p.solution(bandage4, 5, attacks4));     // 3
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int[] attackRecord = new int[attacks[attacks.length - 1][0] + 1];
        for (int i = 0; i < attacks.length; i++) {
            attackRecord[attacks[i][0]] = attacks[i][1];
        }
        int success = 0;
        int maxHealth = health;
        for (int i = 0; i < attackRecord.length; i++) {
            if (attackRecord[i] > 0) {
                success = 0;
                health -= attackRecord[i];
            } else {
                success++;
                if (success == bandage[0]) {
                    health += bandage[1] + bandage[2];
                    success = 0;
                } else {
                    health += bandage[1];
                }
            }

            if (health > maxHealth) {
                health = maxHealth;
            }

            if (health <= 0) {
                return -1;
            }
        }

        return health;
    }
}
