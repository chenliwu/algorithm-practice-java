package huawei_online_algorithm;

import java.util.*;
/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 字符串分隔 {

    static final int LEN = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1, string2;
        string1 = scanner.nextLine();
        string2 = scanner.nextLine();
        List<String> stringList1 = get(string1);
        List<String> stringList2 = get(string2);
        for(String string:stringList1){
            System.out.println(string);
        }
        for(String string:stringList2){
            System.out.println(string);
        }
    }

    public static List<String> get(String string) {
        List<String> stringList = new ArrayList<>();
        int strLen = string.length();
        if (strLen < LEN) {
            stringList.add(appenString(string));
        } else {
            int tempNo = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strLen; i++) {
                sb.append(string.charAt(i));
                tempNo++;
                if (tempNo == LEN + 1) {
                    tempNo = 1;
                    stringList.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (strLen % LEN != 0) {
                stringList.add(appenString(sb.toString()));
            }
        }
        return stringList;
    }


    public static String appenString(String string) {
        int strLen = string.length();
        int addLen = LEN - strLen;
        StringBuilder sb = new StringBuilder(string);
        for (int i = 0; i < addLen; i++) {
            sb.append("0");
        }
        return sb.toString();
    }


}
