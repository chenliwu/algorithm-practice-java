package huawei_online_algorithm;

import java.util.Scanner;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 求最小公倍数 {

    public static void main(String[] args) {
        findLcm();
    }

    /**
     * 最小公倍数*最大公约数=两个数的乘积
     */
    public static void findLcm() {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        if (a < b) {
            //交换a、b的值
            a = a + b;
            b = a - b;
            a = a - b;
        }
        int lcm = (a * b) / gcd(a, b);
        System.out.println(lcm);
    }

    /**
     * 求最大公约数
     *
     * @param n
     * @param m
     * @return
     */
    public static int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        } else {
            return gcd(m, n % m);
        }
    }


}
