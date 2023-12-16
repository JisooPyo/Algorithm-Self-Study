package programmers.test2312;

import java.util.HashSet;
import java.util.Set;

public class SkillTree {
    public static void main(String[] args) {
        SkillTree s = new SkillTree();

        String skill1 = "CBD";
        String[] skill_trees1 = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(s.solution(skill1, skill_trees1));
    }

    public int solution(String skill, String[] skill_trees) {
        char[] skills = skill.toCharArray();
        int answer = 0;
        Set<Character> skillsSet = new HashSet<>();
        for (char ch : skills) {
            skillsSet.add(ch);
        }
        loop1:
        for (int i = 0; i < skill_trees.length; i++) {
            char[] skillTree = skill_trees[i].toCharArray();
            int index = 0;
            for (char ch : skillTree) {
                if (skillsSet.contains(ch)) {
                    if (skills[index] == ch) {
                        index++;
                        continue;
                    }
                    continue loop1;
                }
            }
            answer++;
        }
        return answer;
    }
}
// skill_trees의 한 문자열에서 skill에 있는 문자열을 삭제하는 방법도 있었다.
// replaceAll을 이용해서 빠르지는 않을 것 같지만 짧았다!
