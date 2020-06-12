package programmers.q12924;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12924
 * 연습문제 > 숫자의 표
 */
public class Q12924 {
    public int solution(int n) {
        int answer = 1;

        for(int i=1; i<=n ; i++){
            int sum = 0;
            for(int j=i; j<=n; j++) {
                if(sum == n) answer++;
                if(sum > n) break;
                sum += j;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        Q12924 q = new Q12924();
        int n = 15;
        int result = 4;

        Assertions.assertThat(q.solution(n)).isEqualTo(result);
    }
}
