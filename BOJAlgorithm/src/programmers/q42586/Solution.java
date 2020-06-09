package programmers.q42586;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * 스택/큐 > 기능개발
 */
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        int[] days = new int[length];
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();


        for(int i=0; i<length; i++) {
            days[i] = (int)Math.ceil((double)(100 - progresses[i]) / (double)speeds[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(days[0]);
        for(int i=1; i<length; i++) {

            if(queue.element() < days[i]) {
                answerList.add(queue.size());
                queue.clear();
            }
            queue.add(days[i]);

        }
        if(!queue.isEmpty()) {
            answerList.add(queue.size());
            queue.clear();
        }

        answer = answerList.parallelStream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = {2,1};

        int[] solution = s.solution(progresses, speeds);

        Assertions.assertThat(solution).isEqualTo(answer);
    }
}
