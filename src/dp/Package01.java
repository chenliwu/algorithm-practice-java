package dp;

import sun.applet.Main;

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
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            for (int i = 1; i <= n; i++) {
//                w[i] = scanner.nextInt();
//                v[i] = scanner.nextInt();
//            }
//            fun(n, m);
//        }

        //System.out.println((new Package01()).reverseStr("(abc(abc)abc)"));
        //System.out.println((new Package01()).reverseStr("(abc(abc(abc))abc)"));
//        System.out.println((new Package01()).reverseStr("(abcd)"));
        System.out.println((new Package01()).reverseStr("(ed(et(oc))el)"));
//        System.out.println((new Package01()).reverseStr("a(bcdefghijkl(mno)p)q"));
        //System.out.println((new Package01()).reverseStr("ta()usw((((a))))"));
        //System.out.println((new Package01()).reverseStr("kae(c(x((ffr()(t(ky)esr()oc)bl)kwx)qz)a(yovg(())dpx((w(co(tuz))zldu(nukcno(j)nohpg)g)bxp)djjbw))ho(h)"));
    }

    public String reverseStr(String str) {
        StringBuilder ans = new StringBuilder();
        while (true) {
            int leftKhIndex = str.lastIndexOf("(");
            int rightKhIndex = str.indexOf(")");
            if (leftKhIndex == -1 || rightKhIndex == -1) {
                ans.append(str);
                break;
            }
            ans.append(str.substring(0, leftKhIndex));
            ans.append(new StringBuilder(str.substring(leftKhIndex + 1, rightKhIndex)).reverse());
            ans.append(str.substring(rightKhIndex + 1));
            // System.out.println(ans);
            str = ans.toString();
            ans = new StringBuilder();
        }
        return ans.toString();
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
