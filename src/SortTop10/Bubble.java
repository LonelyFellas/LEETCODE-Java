package SortTop10;

import java.util.Arrays;

public class Bubble {
    public Bubble() {

    }

    /**
     * 一般的冒泡,
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int n = 0; n < len - 1 - i; n++) {
                if (array[n] > array[n + 1]) {
                    swap(array, n, n + 1);
                }
            }
        }

        return array;
    }

    /**
     * 进一步优化的冒泡
     *
     * @param array
     * @return
     */
    public int[] sortBetter(int[] array) {
        boolean swappered = true;
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            /*
              如果swappered为false，则代码前面是有序，
              不需要冒泡沉底操作，
              直接跳出循环
             */
            if (!swappered) break;
            swappered = false;

            for (int n = 0; n < len - 1 - i; n++) {
                if (array[n] > array[n + 1]) {
                    swap(array, n, n + 1);
                    swappered = true;
                }
            }
        }

        return array;
    }

    /**
     * 对第二种方法再次优化
     * @param array
     * @return
     */
    public int[] myBubbleSortBest(int[] array) {
        int indexOfLastUnsortedElement = array.length - 1;
        boolean swappered = true;
        int swapperIndex = -1;

        while (swappered) {
            swappered = false;
            for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swappered = true;
                    swapperIndex = i;
                }
            }
            indexOfLastUnsortedElement = swapperIndex;
        }

        return array;
    }

    public String minNumber(int[] num) {
        int indexOfLastUnsortedElement = num.length;
        boolean swappered = true;
        int swapperIndex = -1;

        while (swappered) {
            swappered = false;
            for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                String str1 = String.valueOf(num[i]);
                String str2 = String.valueOf(num[i+1]);
                String str_1 = str1 + str2;
                String str_2 = str2 + str1;
                if (str_1.compareTo(str_2) <= 0) {
                   swap(num, i, i + 1);
                   swappered = true;
                   swapperIndex = i;
                }
            }

            indexOfLastUnsortedElement = swapperIndex;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : num ) {
            sb.append(n);
        }

        return sb.toString();
    }

    public void moveZeros(int[] nums) {
        boolean swappered = true;
        int len = nums.length;

        int swapperIndex = 0;
        for (int i = 0; i < len; i++) {
            if (!swappered) break;
            swappered = false;
            boolean hasFirstIndex = false;
            for (int n = swapperIndex; n < len - 1 - i; n++) {
                if (nums[n] == 0) {
                    if (nums[n + 1] == 0) {
                        if (!hasFirstIndex) {
                            swapperIndex = n;
                            hasFirstIndex = true;
                            swappered = true;
                        }
                        continue;
                    };
                    int temp = nums[n];
                    nums[n] = nums[n + 1];
                    nums[n + 1] = temp;
                    if (!hasFirstIndex) {
                        swapperIndex = n + 1;
                        hasFirstIndex = true;
                        swappered = true;
                    }
                }
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }
}
