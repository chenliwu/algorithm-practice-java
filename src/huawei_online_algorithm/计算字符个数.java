package huawei_online_algorithm;

import java.util.Scanner;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 计算字符个数 {

    public static void main(String[] args) {
        fun();
    }


    public static void fun() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        char ch = str2.charAt(0);
        int count = 0;
        for (int i = 0, len = str1.length(); i < len; i++) {
            if (ch == str1.charAt(i) || ch + 32 == str1.charAt(i)
                    || ch - 32 == str1.charAt(i)) {
                count++;
            }

        }
        System.out.println(count);
    }

}
