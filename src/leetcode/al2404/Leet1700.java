package leetcode.al2404;

import java.util.LinkedList;
import java.util.Queue;

public class Leet1700 {
    public static void main(String[] args) {
        Leet1700 l = new Leet1700();
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};

        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};

        System.out.println(l.countStudents(students1, sandwiches1));
        System.out.println(l.countStudents(students2, sandwiches2));
    }

    // 내 풀이
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentsQueue.add(students[i]);
        }

        int rotationCount = 0;
        int sandIndex = 0;
        while (
            !studentsQueue.isEmpty()
                && rotationCount < studentsQueue.size()
                && sandIndex < sandwiches.length
        ) {
            int student = studentsQueue.poll();
            if (student == sandwiches[sandIndex]) {
                sandIndex++;
                rotationCount = 0;
            } else {
                studentsQueue.add(student);
                rotationCount++;
            }
        }

        return studentsQueue.size();
    }

    // 다른 사람 풀이
    // 단순히 특정 타입의 샌드위치를 선호하는 학생의 수를 세어 문제를 해결할 수 있다.
    public int countStudentsOther(int[] students, int[] sandwiches) {
        int ones = 0; //count of students who prefer type1
        int zeros = 0; //count of students who prefer type0

        for (int stud : students) {
            if (stud == 0)
                zeros++;
            else
                ones++;
        }

        // for each sandwich in sandwiches
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {  // if sandwich is of type0
                if (zeros == 0) { // if no student want a type0 sandwich
                    return ones;
                }
                zeros--;
            } else {  // if sandwich is of type1
                if (ones == 0) {  // if no student want a type1 sandwich
                    return zeros;
                }
                ones--;
            }
        }
        return 0;
    }
}
