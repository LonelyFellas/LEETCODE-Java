package SearchBinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    public Day2() {

    }

    /**
     * Leetcode NO.剑指Office II 069 山峰数组的顶端 -
     * 二分搜索法
     * @param arr 山峰的数据
     * @return 山峰的顶峰的下标
     */
    public int peekIndexInMountainArrayBySearch(int[] arr) {
       int i = 0;
       int j = arr.length - 1;

       while(i < j) {
           int mid = (i + j) / 2;
           if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
               i = mid;
               break;
           } if (arr[mid] < arr[mid + 1]) {
               i = mid;
           } else if (arr[mid] < arr[mid - 1]) {
               j = mid;
           }
       }

       return i;
    }

    /**
     * Leetcode NO.剑指Office II 069 山峰数组的顶端 -
     * 双指针的解法
     * @param arr 山峰的数据
     * @return 山峰的顶峰的下标
     */
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int i = 0;
        int j = len - 1;
        int lastI = -1;
        int lastJ = -1;
        int top = -1;
        while(i <= j) {
            if (arr[i] <= lastI || arr[j] <= lastJ) {
                top = arr[i] <= lastI ? i - 1 : j + 1;
                break;
            }
            lastI = arr[i];
            lastJ = arr[j];
            i++;
            j--;
        }
        if (top == -1) {
            int mid = len / 2;
            top = arr[mid - 1] < arr[mid] ? mid : mid - 1;
        }

        return top;
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
