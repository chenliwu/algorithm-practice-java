package sort;

/**
 * @author chenlw
 * @date 2020/03/14
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        int a[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int n = 10;
        selectSort(a, 10);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void selectSort(int[] a, int n) {
        int minValueIndex;
        for (int i = 0; i < n - 1; i++) {
            minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minValueIndex]) {
                    // 找出关键字最小的下标
                    minValueIndex = j;
                }
            }
            if (minValueIndex != i) {
                // 将关键字最小的值放到前面来
                int temp = a[i];
                a[i] = a[minValueIndex];
                a[minValueIndex] = temp;
            }
        }
    }

}
