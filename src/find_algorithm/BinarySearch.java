package find_algorithm;

/**
 * @author chenlw
 * @date 2020/02/29
 */
public class BinarySearch {

    public static void main(String[] args) {
        testIncreasingArray();
        testDfsBinarySearch();
    }


    public static void testIncreasingArray() {
        System.out.println();
        int r[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int findKey = 5;
        int findIndex = binarySearch(r, 0, r.length - 1, findKey);
        if (findIndex == -1) {
            System.out.println("找不该元素！");
        } else {
            System.out.println(findIndex + "在数组当中的下标为：" + findIndex);
        }
    }

    public static void testDfsBinarySearch() {
        System.out.println();
        int r[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int findKey = 5;
        int findIndex = binarySearchRes(r, 0, r.length - 1, findKey);
        if (findIndex == -1) {
            System.out.println("找不该元素！");
        } else {
            System.out.println(findIndex + "在数组当中的下标为：" + findIndex);
        }
    }


    /**
     * 折半查找- 循环实现
     * <p>
     * 数组存储在数组r[low...high]当中，用折半查找的方式在数组r当中查找值为key的元素
     *
     * @param r
     * @param low
     * @param high
     * @param key
     * @return
     */
    public static int binarySearch(int r[], int low, int high, int key) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == r[mid]) {
                // 查找到该元素值
                return mid;
            } else if (key < r[mid]) {
                // 待查找值关键小于中间值，往前半个子表查询
                high = mid - 1;
            } else {
                // 待查找值大于中间值，往后半个子表查询
                low = mid + 1;
            }
        }
        // 找不到的时候返回-1
        return -1;
    }

    /**
     * 折半查找-递归实现
     *
     * @param r
     * @param low
     * @param high
     * @param key
     * @return
     */
    public static int binarySearchRes(int r[], int low, int high, int key) {
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (key == r[mid]) {
                return mid;
            } else if (key < r[mid]) {
                // 往前半个子表查询
                return binarySearchRes(r, low, mid - 1, key);
            } else {
                // 往后半个子表查询
                return binarySearchRes(r, mid + 1, high, key);
            }
        }
        return -1;
    }

}
