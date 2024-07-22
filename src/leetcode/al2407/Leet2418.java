package leetcode.al2407;

import java.util.Arrays;

/**
 * Easy
 * 2418. Sort the People
 *
 * 문자열 배열 names 와 양의 서로 다른 정수들로 구성되어 있는 배열 heights 가 주어집니다.
 * 두 배열의 길이는 n 입니다.
 * 각 index i에서, names[i]와 heights[i]는 i번째 사람의 이름과 키를 나타냅니다.
 * 사람들의 키를 기준으로 내림차순 정렬된 names 를 return 하세요.
 */
public class Leet2418 {
    // 내 풀이 : 7ms
    public String[] sortPeople(String[] names, int[] heights) {
        Person[] persons = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            persons[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(persons, (a, b) -> b.height - a.height);

        for (int i = 0; i < persons.length; i++) {
            names[i] = persons[i].name;
        }
        return names;
    }

    class Person {
        String name;
        int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
