package leetcode.al2404;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 514. Freedom Trail
 *
 * Fallout 4 비디오 게임
 * "Road to Freedom" 퀘스트
 * 1. "Freedom Trail Ring"이라고 불리는 금속 다이얼에 도달할 것
 * 2. 문을 열기 위한 특정한 키워드의 철자를 다이얼을 이용해 쓸 것
 *
 * Given
 * ring : String, 바깥쪽 링에 새겨진 코드
 * key : 철자를 입력해야 하는 키워드
 *
 * Return
 * keyword의 문자들의 철자를 입력하는 최소 스텝의 수
 *
 * 처음에 링의 첫번째 문자는 12시 방향에 할당되어 있다.
 * 링을 돌려서 key의 문자를 입력해야 한다.
 * 링은 시계방향이나 반시계방향으로 한 번 돌릴 수 있다. 이것이 한 스텝.
 * 회전의 최종 목적은 key[i]와 같은 링의 문자들 중 하나를 12시 방향에 할당시키는 것
 * 만약 key[i]가 12시 방향에 위치하면 철자를 입력하기 위해 가운데 버튼을 누른다. 이것 또한 한 스텝으로 계산한다.
 *
 */
public class Leet514 {
    public static void main(String[] args) {
        Leet514 l = new Leet514();

        System.out.println(l.findRotateSteps("godding", "gd"));
        System.out.println(l.findRotateSteps("godding", "godding"));
    }

    // 다른 사람의 풀이
    public int findRotateSteps(String ring, String key) {
        final int n = ring.length();
        final int k = key.length();
        final int[][] memo = new int[k][n];
        final byte[] keyc = new byte[k];
        key.getBytes(0, k, keyc, 0);

        // Get index positions of all of the same letters.  i.e. In
        // the positions 2-D array, for each letter 'a'..'z', setup
        // an array of the indexes of the letter, ended in a -1.  For
        // example, the array positions['k'-96][] becomes filled with
        // all of the indexes of all the 'k's in the ring string,
        // followed by a -1.  After this, the original string will
        // not be needed, because the positions[][] contains all the
        // needed information, compressed into a more efficiently
        // usable format.
        final int[] letterCounts = new int[26];
        final int[][] positions = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            int c = ring.charAt(i) - 'a';
            positions[c][letterCounts[c]++] = i;
        }
        for (int c = 0; c < 26; c++)
            positions[c][letterCounts[c]] = -1;

        // Call the recursion routine to start at the first letter
        // of the key, and do a DFS with memorization to find the
        // shortest number of steps.
        return findMinSteps(positions, keyc, memo, n, 0, 0);
    }

    // Recursive routine that calculates the minimum number of steps
    // starting at index keyIdx into the key string.  Use memorization
    // to make the Depth First Search (DFS) run faster.
    // Input:
    //   positions[][]   Indexes of for each letter in the ring string.
    //   keyc[]          Key string, converted to an array of bytes.
    //   memo[][]        Memorization values by keyIdx and atTop.
    //   n               Number of characters in the ring string.
    //   atTop           Index into ring string that is at top of dial.
    //   keyIdx          Index into key string of char to dial to.
    // Output:
    //   Minimum number of steps to dial from the keyIdx'th character
    //   of the ring string, to the end of the ring string.
    private int findMinSteps(int[][] positions, byte[] keyc, int[][] memo,
        int n, int atTop, int keyIdx) {
        if (keyIdx >= keyc.length)
            return 0;
        int c = keyc[keyIdx] - 'a';
        if (memo[keyIdx][atTop] != 0)
            return memo[keyIdx][atTop];

        // Try using all possible positions of the current key character
        // to dial the remainder of the key string.  Collect the minimum
        // number of steps from dialing each copy of the current key
        // character within the ring string.
        int[] pos = positions[c];
        int minSteps = Integer.MAX_VALUE;
        for (int p : pos) {
            if (p < 0)
                break;
            int dist = ((atTop + n) - p) % n;
            dist = Math.min(dist, n - dist);
            minSteps = Math.min(minSteps, dist + findMinSteps(positions,
                keyc, memo, n, p, keyIdx + 1));
        }
        return memo[keyIdx][atTop] = minSteps + 1;
    }
}
