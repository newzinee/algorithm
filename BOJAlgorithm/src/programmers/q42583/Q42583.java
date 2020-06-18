package programmers.q42583;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 다리를 지나는 트럭
 */
public class Q42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int idx = 0;
        int[] count = new int[truck_weights.length];
        int out = 0;
        int input = 0;

        Queue<Integer> queue = new LinkedList<>();
        while(out < truck_weights.length) {
            int sum = queue.stream().mapToInt(Integer::intValue).sum();
            if (input < truck_weights.length && sum + truck_weights[input] <= weight) {
                queue.add(truck_weights[input]);
                input++;
            }
            for(int i=idx; i<input; i++) {
                count[i]++;
            }
            if(count[idx] == bridge_length) {
                idx++;
                queue.poll();
                out++;
            }
            answer++;
        }

        return answer;
    }

    @Test
    public void test1() {
        Q42583 q = new Q42583();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int result = 8;

        Assertions.assertThat(q.solution(bridge_length, weight, truck_weights)).isEqualTo(result);
    }

    @Test
    public void test2() {
        Q42583 q = new Q42583();
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};
        int result = 101;

        Assertions.assertThat(q.solution(bridge_length, weight, truck_weights)).isEqualTo(result);
    }

    @Test
    public void test3() {
        Q42583 q = new Q42583();
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int result = 110;

        Assertions.assertThat(q.solution(bridge_length, weight, truck_weights)).isEqualTo(result);
    }


}
