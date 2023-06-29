package SortTop10;

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

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }
}
