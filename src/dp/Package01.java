package dp;

import java.util.Scanner;

import static java.lang.Integer.max;

/**
 * @author chenlw
 * @since 2020-11-15
 */
public class Package01 {

    public static int[] dp = new int[5001];
    public static int[] w = new int[201];
    public static int[] v = new int[201];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                w[i] = scanner.nextInt();
                v[i] = scanner.nextInt();
            }
            fun(n, m);
        }
    }

    public static void fun(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= w[i]; j--) {
                dp[j] = max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[m]);
    }

}
