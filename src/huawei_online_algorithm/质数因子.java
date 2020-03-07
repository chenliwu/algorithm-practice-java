package huawei_online_algorithm;

import java.util.Scanner;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 质数因子 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            //fun(number);
            System.out.println(getResult(number));
        }

    }

    private static void fun(long num) {
        long number = num;
        while (number != 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    number /= i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }

    public static String getResult(long number) {
        StringBuilder sb = new StringBuilder();
        while (number != 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    number /= i;
                    // System.out.print(i + " ");
                    sb.append(i + " ");
                    break;
                }
            }
        }
        return sb.toString();
    }

}
