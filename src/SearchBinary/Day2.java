package SearchBinary;

import java.util.*;
import java.util.ArrayList;

public class Day2 {
    public Day2() {

    }

    /**
     * Leetcode NO.1337 矩阵中战斗力最弱的 K 行
     * @param mat 矩阵数据
     * @param k 需要从弱到强的数列的个数
     * @return 返回相应个数的数组
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int len = mat.length;
        List<int[]> list = new ArrayList<>();
        int[] result = new int[k];
        for (int n = 0; n < len; n++) {
            int i = 0;
            int j = mat[n].length - 1;
            while(i <= j && mat[n][0] != 0) {
                int mid =  (i + j) / 2;
                if (mat[n][mid] == 1 && mid == mat[n].length - 1 || mat[n][mid] == 1 && mat[n][mid + 1] == 0) {
                    i = mid;
                    break;
                } else if (mat[n][mid] == 1) {
                    i = mid + 1;
                } else if (mat[n][mid] == 0) {
                    j = mid - 1;
                }
            }
            list.add(new int[] {n, mat[n][0] == 0 ? 0 : i + 1});
        }
        list = sortedListByIndex(list);
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[0];
        }

        return result;
    }
    public List<int[]> sortedListByIndex(List<int[]> list) {
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        return list;
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
