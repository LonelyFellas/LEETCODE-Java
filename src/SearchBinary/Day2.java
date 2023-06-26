package SearchBinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    public Day2() {

    }

    /**
     * Leetcode No.2389 和有限的最长子序列
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);

        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + nums[i];
        }
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = binarySearch(f, queries[i]) - 1;
        }

        return answer;
    }

    public int binarySearch(int[] f, int target) {
        int low = 1, high = f.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
