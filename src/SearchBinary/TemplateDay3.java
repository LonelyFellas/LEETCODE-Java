package SearchBinary;

public class TemplateDay3 {
    public TemplateDay3() {

    }
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Leetcode: https://leetcode.com/problems/sqrtx/
     * Implement int sqrt(int x).
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
     * Example 1:
     * Input: 4
     * Output: 2
     * Example 2:
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     * the decimal part is truncated, 2 is returned.
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
