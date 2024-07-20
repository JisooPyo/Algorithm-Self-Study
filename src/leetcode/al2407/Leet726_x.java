package leetcode.al2407;

import java.util.Map;
import java.util.TreeMap;

/**
 * Hard
 * 726. Number of Atoms
 *
 * 주어진 화학식 문자열 formula가 주어졌을 때, 각 원자의 개수를 반환하시오.
 * 원소의 이름은 항상 대문자로 시작하며, 그 뒤에 하나 이상의 소문자가 나올 수 있습니다.
 * 해당 원소의 개수가 1보다 큰 경우, 그 뒤에 하나 이상의 숫자가 나올 수 있습니다.
 * 만약 개수가 1이라면 숫자는 나오지 않습니다.
 * 예를 들어, "H2O"와 "H2O2"는 가능한 경우지만 "H1O2"는 불가능한 경우입니다.
 * 두 개의 화학식이 연결되어 또 다른 화학식을 만들 수 있습니다.
 *
 * 예를 들어, "H2O2He3Mg4" 또한 화학식입니다.
 * 화학식을 괄호로 묶고, (선택적으로) 그 뒤에 개수가 나올 수도 있습니다.
 *
 * 예를 들어, "(H2O2)"와 "(H2O2)3"는 화학식입니다.
 * 모든 원소의 개수를 문자열 형태로 반환하되, 첫 번째 이름(정렬된 순서로)을 반환하고,
 * 그 개수가 1보다 큰 경우 개수를 표시하며,
 * 그 다음 두 번째 이름(정렬된 순서로)과 그 개수(만약 1보다 큰 경우)를 표시하는 형태로 반환하시오.
 *
 * 테스트 케이스는 출력되는 모든 값이 32비트 정수 내에 맞도록 생성됩니다.
 */
public class Leet726_x {
    public static void main(String[] args) {
        Leet726_x l = new Leet726_x();
        // System.out.println(l.countOfAtoms("H2O"));  // "H2O"
        System.out.println(l.countOfAtoms("Mg(OH)2"));  // "H2MgO2"
        System.out.println(l.countOfAtoms("K4(ON(SO3)2)2"));    // "K4(ON(SO3)2)2"
    }

    // 내 접근
    // TreeMap, StringBuilder 2개 이용, 재귀

    // 다른 사람의 풀이 : 2ms
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        int[] stack = new int[1000];
        int top = 0, multiplier = 1, freq = 0;
        char[] c = formula.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                int end = i--;
                while (i >= 0 && c[i] >= 'a' && c[i] <= 'z')
                    i--;
                String key = new String(c, i, end - i + 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                String key = new String(c, i, 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= '0' && c[i] <= '9') {
                freq = c[i] - '0';
                int p = 10;
                while (i - 1 >= 0 && c[i - 1] >= '0' && c[i - 1] <= '9') {
                    freq += p * (c[--i] - '0');
                    p *= 10;
                }
            } else if (c[i] == ')') {
                stack[top++] = multiplier;
                multiplier *= Math.max(freq, 1);
                freq = 0;
            } else {
                multiplier = stack[--top];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
