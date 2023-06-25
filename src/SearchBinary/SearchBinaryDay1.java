package SearchBinary;

import java.util.*;

public class SearchBinaryDay1 {
    public SearchBinaryDay1() {

    }

    /**
     * Leetcode No.349 两个数组的交集
     * @param nums1 数组1
     * @param nums2 数组2
     * @return int[]类型的交集数
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            if (search(nums2, num, true) != -1) {
               set.add(num);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Leetcode No.1213 三个有序数组的交集
     * @param arr1 数组1
     * @param arr2 数组2
     * @param arr3 数组3
     * @return 结果三个数组的交集 -> list
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<Integer>();
        for (int number : arr1) {
            if (search(arr2, number, false) != -1 && search(arr3, number, false) != -1) {
               list.add(number);
            }
        }
        return list;
    }

    /**
     * Leetcode No.704 位置查找
     * @param nums 给定的数组
     * @param target 搜索的目标
     * @param isSort 是否要对数组进行排序
     * @return 返回目标第一个下标
     */
    public int search(int[] nums, int target, boolean isSort) {
        if (isSort) {
            Arrays.sort(nums);
        }
       int left = 0;
       int right = nums.length - 1;

       while (left <= right) {
           int mid = (left + right) / 2;
           if (nums[mid] == target) {
               return mid;
           } else if (nums[mid] < target) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }

       return -1;
    }

    /**
     * Leetcode No.2089 找出数据排序后的目标下标
     *
     * @param nums 给定的数组
     * @param target 搜索目标
     * @return 返回数组中所有等于目标值的下标
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        // 第一步先排好序
        Arrays.sort(nums);

        int len = nums.length;
        int left = 0;
        int right = len - 1;

        List<Integer> indices = new ArrayList<>();
        while (left <= right) {
            int mid = (right + left) / 2;
            // 当到mid为止，找到了target，则还要继续望左边和右边找是否有重复
            if (nums[mid] == target) {
                // 判断左边是否有重复target，如果有，想左边拓展
                int j = mid - 1;
                while (j >= 0 && target == nums[j]) {
                    // 根据题意，要求返回一个递增顺序序列，所以向左添加需要从序列的头部添加
                    indices.add(0, j);
                    j--;
                }
                indices.add(mid);
                // 相同逻辑判断右边的情况
                int k = mid + 1;
                while (k < len && target == nums[k]) {
                    indices.add(k);
                    k++;
                }
                // 跳脱loop
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return indices;
    }


}
