import java.util.*;


public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().solve(10, 16));
//        System.out.println(new Solution().solve(10, 2));
//        System.out.println(new Solution().solve(0, 2));
        System.out.println(new Solution().solve(-4, 3));
    }

    /**
     * 进制映射
     */
    private static Map<String, String> jzMap = new HashMap<>();

    static {
        for (int i = 0; i <= 9; i++) {
            jzMap.put(String.valueOf(i), String.valueOf(i));
        }
        char ch = 'A';
        for (int i = 10; i <= 15; i++) {
            jzMap.put(String.valueOf(i), String.valueOf(ch));
            ch++;
        }
    }

    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve(int M, int N) {
        if (M == 0) {
            return "0";
        }
        boolean fsFlag = false;
        if (M < 0) {
            M = Math.abs(M);
            fsFlag = true;
        }
        // 模n取余数  逆序法
        int m = M;
        StringBuilder ans = new StringBuilder();
        while (m != 0) {
            int mod = m % N;
            ans.append(jzMap.get(String.valueOf(mod)));
            m = m / N;
        }
        ans = ans.reverse();
        return (fsFlag ? "-" : "") + ans.toString();
    }
}
