package leetcode.al2404;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leet950 {
    public static void main(String[] args) {
        Leet950 l = new Leet950();

        int[] deck1 = {17, 13, 11, 2, 3, 5, 7};
        int[] deck2 = {1, 1000};
        int[] deck3 = {1, 3, 5, 7, 9, 11, 13, 15, 2, 4, 6, 8, 10, 12, 14};

        // System.out.println(Arrays.toString(l.deckRevealedIncreasing(deck1)));
        // System.out.println(Arrays.toString(l.deckRevealedIncreasing(deck2)));
        System.out.println(Arrays.toString(l.deckRevealedIncreasing(deck3)));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int[] answer = new int[deck.length];
        int deckIndex = 0;
        int ansIndex = 0;
        boolean insert = true;
        while (deckIndex < deck.length) {
            if (answer[ansIndex] == 0 && insert) {
                answer[ansIndex++] = deck[deckIndex++];
                insert = false;
            } else if (answer[ansIndex] == 0 && !insert) {
                ansIndex++;
                insert = true;
            } else {
                ansIndex++;
            }
            if (ansIndex == deck.length) {
                ansIndex = 0;
            }
        }
        return answer;
    }
}
