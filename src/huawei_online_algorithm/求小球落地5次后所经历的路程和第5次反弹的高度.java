package huawei_online_algorithm;

import java.util.Scanner;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 求小球落地5次后所经历的路程和第5次反弹的高度 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
//            double init = scanner.nextDouble();
//            System.out.println(init * 2.875);
//            System.out.println(init / 32);

            double init = scanner.nextDouble();
            System.out.println(init * 2.875);
            System.out.println(0.03125 * (int) init);
        }
    }

}
