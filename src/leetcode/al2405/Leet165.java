package leetcode.al2405;

public class Leet165 {
    public static void main(String[] args) {
        Leet165 l = new Leet165();

        System.out.println(l.compareVersion("1.01", "1.001"));
        System.out.println(l.compareVersion("1.0", "1.0.0"));
        System.out.println(l.compareVersion("0.1", "1.1"));
    }

    // 나의 풀이
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int len = Math.max(split1.length, split2.length);

        int[] ver1 = new int[len];
        int[] ver2 = new int[len];

        for (int i = 0; i < split1.length; i++) {
            ver1[i] = Integer.parseInt(split1[i]);
        }
        for (int i = 0; i < split2.length; i++) {
            ver2[i] = Integer.parseInt(split2[i]);
        }

        for (int i = 0; i < ver1.length; i++) {
            if (ver1[i] == ver2[i]) {
                continue;
            } else if (ver1[i] > ver2[i]) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    // 다른 사람의 풀이
    // char를 비교해서 좀 더 빠르게 풀었다.
}
