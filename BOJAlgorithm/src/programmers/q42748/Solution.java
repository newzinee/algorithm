package programmers.q42748;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * 정렬 > K번째수
 */
public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            int[] arr = new int[commands[i][1] - commands[i][0] +1];
            int start = commands[i][0] - 1;
            for(int j=0; j<arr.length;j++) {
                arr[j] = array[start+j];
            }
            Arrays.sort(arr);

            answer[i] = arr[commands[i][2]-1];
        }

        return answer;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = s.solution(array, commands);
        int[] answer = {5,6,3};

        Assertions.assertThat(solution).isEqualTo(answer);
    }
}