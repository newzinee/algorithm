package programmers.q49993;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 * 스킬트리
 */
public class Q49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int[] alphabet = new int[26];
        for(int i=0; i< skill.length(); i++) {
            int ch = skill.charAt(i);
            alphabet[ch-65] = i+1;
        }
        for (int i = 0; i < skill_trees.length; i++) {
            int min = 0;
            for(int j=0; j< skill_trees[i].length(); j++) {
                int ch = skill_trees[i].charAt(j);

                if(j == skill_trees[i].length()-1 || min == skill.length()) {
                    if(alphabet[ch-65] - min >= 2) break;
                    answer++;
                    break;
                }
                if(alphabet[ch-65] == 0) continue;
                if(alphabet[ch-65] - min >= 2) break;
                min = alphabet[ch-65];

            }
        }

        return answer;
    }

    @Test
    public void test1() {
        Q49993 q = new Q49993();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int result = 2;

        Assertions.assertThat(q.solution(skill, skill_trees)).isEqualTo(result);
    }

    @Test
    public void test2() {
        Q49993 q = new Q49993();
        String skill = "EA";
        String[] skill_trees = { "BDA", "BACDE", "CBADF", "AECB"};
        int result = 0;

        Assertions.assertThat(q.solution(skill, skill_trees)).isEqualTo(result);
    }
}
