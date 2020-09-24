package programmers.q68644;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * 월간 코드 챌린지 시즌1 > 두 개 뽑아서 더하기
 */
public class Q68644 {

    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();

        for(int i=0; i < numbers.length; i++) {
            for(int j=i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();

        return answer;
    }

    @Test
    public void test1() {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] result = {2, 3, 4, 5, 6, 7};
        Q68644 q = new Q68644();

        assertThat(q.solution(numbers)).isEqualTo(result);

    }

    @Test
    public void test2() {
        int[] numbers = {5,0,2,7};
        int[] result = {2,5,7,9,12};
        Q68644 q = new Q68644();

        assertThat(q.solution(numbers)).isEqualTo(result);

    }
}
