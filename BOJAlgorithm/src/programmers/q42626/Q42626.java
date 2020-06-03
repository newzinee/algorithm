package programmers.q42626;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 힙(heap) > 더 맵게
 */
public class Q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));


        while(queue.peek() < K)  {
            answer++;
            queue.add(queue.poll() + queue.poll()*2);
            if(queue.size() == 1 && queue.peek() < K) return -1;
        }
        return answer;
    }

    @Test
    public void test() {
        Q42626 q = new Q42626();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        Assertions.assertThat(q.solution(scoville, K)).isEqualTo(2);
    }

    @Test
    public void test1() {
        Q42626 q = new Q42626();
        int[] scoville = {1,1,1,1};
        int K = 10;

        Assertions.assertThat(q.solution(scoville, K)).isEqualTo(-1);
    }

    @Test
    public void test2() {
        Q42626 q = new Q42626();
        int[] scoville = {1,1,1,1};
        int K = 0;

        Assertions.assertThat(q.solution(scoville, K)).isEqualTo(0);
    }
}
