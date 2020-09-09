package programmers.q42584;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * 주식가격
 */
public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length-1; i++) {
            int count=1;
            for(int j=i+1; j<prices.length-1; j++) {
                if(prices[i] > prices[j]) {
                    break;
                }else {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    @Test
    public void test() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = {4, 3, 1, 1, 0};

        Solution s = new Solution();

        Assertions.assertThat(s.solution(prices)).isEqualTo(answer);
    }

}

