package leetcode.al2402;

public class Leet58 {
    public int lengthOfLastWord(String s) {
        String[] splits = s.split(" +");
        return splits[splits.length-1].length();
    }
}
