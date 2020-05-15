package programmers.q42578;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 * 해시 > 위장
 */
public class Solution {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> hash = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            Integer count = hash.get(clothes[i][1]) == null ? 1 : hash.get(clothes[i][1]) +1;
            hash.put(clothes[i][1], count);
        }

        for (Integer value : hash.values()) {
            answer *= (value+1);
        }

        answer -= 1;

        return answer;
    }

    @Test
    public void run() {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution s = new Solution();
        Assertions.assertThat(s.solution(clothes)).isEqualTo(5);
    }
}
