package programmers.q17681;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 * 2018 KAKAO BLIND RECRUITMENT > [1차] 비밀지도
 */
public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i < n; i++) {
            int bit = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(bit);
            answer[i] = String.format("%"+n+"s", binary).replaceAll("1", "#").replaceAll("0", " ");
        }

        return answer;
    }

    @Test
    public void test1() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = {"#####", "# # #", "### #", "#  ##", "#####"};

        Solution s = new Solution();
        assertThat(s.solution(n, arr1, arr2)).isEqualTo(answer);
    }

    @Test
    public void test2() {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] answer = {"######", "###  #", "##  ##", " #### ", " #####", "### # "};

        Solution s = new Solution();
        assertThat(s.solution(n, arr1, arr2)).isEqualTo(answer);
    }
}
