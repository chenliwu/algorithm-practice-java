package huawei_online_algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author chenlw
 * @date 2020/02/29
 */
public class CountChars {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }

        // countChar();
        countChar1();
    }

    public static void countChar() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int temp;
        Set<Character> countSet = new HashSet<>();
        for (char ch : chars) {
            temp = ch;
            if (temp >= 0 && temp <= 127) {
                countSet.add(ch);
            }
        }
        System.out.println(countSet.size());
    }

    public static void countChar1() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] charsCount = new int[128];
        char[] chars = str.toCharArray();
        int temp;

        for (char ch : chars) {
            temp = ch;
            if (temp >= 0 && temp <= 127) {
                charsCount[temp] = 1;
            }
        }
        int ans = 0;
        for (int i=0;i<128;i++){
            if(charsCount[i] == 1){
                ans++;
            }
        }
        System.out.println(ans);
    }

}
