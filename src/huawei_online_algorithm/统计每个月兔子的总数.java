package huawei_online_algorithm;

import java.util.*;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 统计每个月兔子的总数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int month = scanner.nextInt();
            //a:一个月兔子数，b：两个月兔子数，c：三个月兔子个数
            int a = 1, b = 0, c = 0;
            while ((--month) != 0) {
                c = c + b;
                b = a;
                a = c;
            }
            System.out.println(a + b + c);
        }
    }
}
