package programmers.q12913;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 * 땅따먹기
 */
public class Q12913 {

    int solution(int[][] land) {
        int answer = 0;
        int idx = land.length-1;

        for(int i=1; i<land.length; i++) {
            land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += max(land[i-1][1], land[i-1][0], land[i-1][3]);
            land[i][3] += max(land[i-1][1], land[i-1][2], land[i-1][0]);
        }

        answer = max(land[idx][0], land[idx][1], land[idx][2], land[idx][3]);
        return answer;
    }

    private int max(int i, int j, int k) {
        return i < j ? (j < k ? k : j) : (i < k ? k : i);
    }

    private int max(int i, int j, int k, int m) {
        return max(i,j,k) < m ? m : max(i,j,k);
    }

    @Test
    public void test1() {
        Q12913 q = new Q12913();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int result = 16;

        Assertions.assertThat(q.solution(land)).isEqualTo(result);
    }
}
