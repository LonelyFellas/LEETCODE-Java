package SearchBinary;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SearchBinaryDay1 {
    public SearchBinaryDay1() {

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
