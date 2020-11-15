package huawei_online_algorithm;

import java.util.Scanner;

/**
 * @author chenlw
 * @since 2020-11-15
 */
public class 查找两个字符串的最长公共子串 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            if (str1.length() > str2.length()) {
                // str1 为短串
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            System.out.println(fun(str1, str2));
        }
    }


    public static String fun(String str1, String str2) {
        int maxSubStringLen = 1;
        String maxSubString = str1.substring(0, 1);
        for (int sublen = 1; sublen <= str1.length(); sublen++) {
            // 字串遍历次数
            int count = str1.length() - sublen + 1;
            for (int i = 0; i < count; i++) {
                int startIndex = i;
                int endIndex = i + sublen;
                String subStr = str1.substring(startIndex, endIndex);
                if (str2.contains(subStr)) {
                    if (subStr.length() > maxSubStringLen) {
                        maxSubStringLen = subStr.length();
                        maxSubString = subStr;
                    }
                }
            }
        }
        return maxSubString;
    }

}
