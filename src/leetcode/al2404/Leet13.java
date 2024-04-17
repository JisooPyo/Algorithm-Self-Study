package leetcode.al2404;

public class Leet13 {
    public static void main(String[] args) {
        Leet13 l = new Leet13();

        System.out.println(l.romanToInt("III"));
        System.out.println(l.romanToInt("LVIII"));
        System.out.println(l.romanToInt("MCMXCIV"));
    }

    // 내 풀이
    public int romanToInt(String s) {
        char[][] chars = {{'I', 'V'}, {'X', 'L'}, {'C', 'D'}, {'M', ' '}};
        String[][] strs = {
            {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"M", "MM", "MMM"}
        };
        int answer = 0;
        int position = 3;
        StringBuilder sb = new StringBuilder(s);

        while (!sb.isEmpty()) {
            if (sb.charAt(0) != chars[position][0]
                && sb.charAt(0) != chars[position][1]) {
                position--;
                continue;
            }

            for (int i = strs[position].length - 1; i >= 0; i--) {
                if (sb.indexOf(strs[position][i]) == 0) {
                    answer += (int)Math.pow(10, position) * (i + 1);
                    sb.delete(0, strs[position][i].length());
                    position--;
                    break;
                }
            }

        }

        return answer;
    }
}
