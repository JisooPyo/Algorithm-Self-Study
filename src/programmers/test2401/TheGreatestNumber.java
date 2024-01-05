package programmers.test2401;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheGreatestNumber {
    public static void main(String[] args) {
        TheGreatestNumber t = new TheGreatestNumber();
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        int[] numbers3 = {1000, 111, 110, 101, 100, 11, 10, 1, 0};
        int[] numbers4 = {547, 54, 5};
        int[] numbers5 = {979, 97, 978, 81, 818, 817};

        System.out.println(t.solution(numbers1));
        System.out.println(t.solution(numbers2));
        System.out.println(t.solution(numbers3));
        System.out.println(t.solution(numbers4));
        System.out.println(t.solution(numbers5));

        System.out.println(new Number("110").compareTo(new Number("11")));  // 1
        System.out.println(new Number("30").compareTo(new Number("3")));    // 1
        System.out.println(new Number("3").compareTo(new Number("30")));    // -1
        System.out.println(new Number("100").compareTo(new Number("10")));    // 1
        System.out.println(new Number("978").compareTo(new Number("97")));    // 1
        System.out.println(new Number("978").compareTo(new Number("97")));    // 1

        // 979 97 978 81881817(ans)
        // 979 97 978 81881817
    }

    public String solution(int[] numbers) {
        List<Number> numToStr = new ArrayList<>();
        for (int i : numbers) {
            numToStr.add(new Number(Integer.toString(i)));
        }

        Collections.sort(numToStr);

        for (int i = 0; i < numToStr.size(); i++) {
            System.out.print(numToStr.get(i).num + ", ");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numToStr.size(); i++) {
            sb.append(numToStr.get(i).num);
        }
        if (sb.toString().matches("^[0]+$")) {
            return "0";
        }
        return sb.toString();
    }

    static class Number implements Comparable<Number> {
        String num;

        public Number(String num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            if (num.equals(o.num)) {
                return 0;
            }
            StringBuilder sb1 = new StringBuilder();
            sb1.append(num);
            sb1.append(o.num);

            StringBuilder sb2 = new StringBuilder();
            sb2.append(o.num);
            sb2.append(num);

            return sb2.compareTo(sb1);
        }
    }
}
