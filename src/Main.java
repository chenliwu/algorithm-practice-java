import java.util.*;

public class Main {

    private int a;

    public static void main(String[] args) {
        int a[] = {1, 1, 2, 2, 3, 4, 4};
        System.out.println(singleNumber(a));
    }

    public static List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap();
        for (int i = 0, len = A.length; i < len; i++) {
            if (countMap.containsKey(A[i])) {
                int count = countMap.get(A[i]);
                countMap.put(A[i], count + 1);
            } else {
                countMap.put(A[i], 1);
            }
        }
        Set<Integer> numSet = countMap.keySet();
        for (Integer integer : numSet) {
            if (countMap.get(integer) != null && countMap.get(integer) != 2) {
                result.add(integer);
            }
        }
        return result;
    }

    public static int singleNumber(int[] A) {
        // write your code here
        int ans = -1;
        Map<Integer, Integer> countMap = new HashMap();
        for (int i = 0, len = A.length; i < len; i++) {
            if (countMap.containsKey(A[i])) {
                int count = countMap.get(A[i]);
                countMap.put(A[i], count + 1);
            } else {
                countMap.put(A[i], 1);
            }
        }
        Set<Integer> numSet = countMap.keySet();
        for (Integer integer : numSet) {
            if (countMap.get(integer) != null && countMap.get(integer) != 3) {
                ans = integer;
                break;
            }
        }
        return ans;

    }


}
