package huawei_online_algorithm;

import java.util.Scanner;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 求int型正整数在内存中存储时1的个数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        int ans = 0;
        while (input != 0) {
            if (input % 2 == 1) {
                ans++;
            }
            input /= 2;
        }
        System.out.println(ans);
    }
}
