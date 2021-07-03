
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            handle(str);
        }
    }

    public static void handle(String str) {
        List<String> ans = getAnsString(str);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    public static List<String> getAnsString(String str) {
        List<String> ans = new ArrayList<>();
        if (Objects.isNull(str) || str.length() == 0) {
            return ans;
        }
        char[] chars = str.toCharArray();
        final int strLen = 8;
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(ch);
            if (sb.length() == strLen) {
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            String zoneStr = "00000000";
            int appendZoneCount = strLen - sb.length();
            sb.append(zoneStr.substring(0,appendZoneCount));
            ans.add(sb.toString());
        }
        return ans;
    }

    /**
     * 计算二进制1的个数 - 模2取余法
     *
     * @param n 数字
     * @return 二进制1的个数
     */
    public static int fun(int n) {
        int ans = 0;
        while (true) {
            // 模2取余法
            if (n % 2 == 1) {
                ans++;
            }
            if (n / 2 == 0) {
                break;
            }
            n = n / 2;
        }
        return ans;
    }

    /**
     * 计算二进制1的个数  按位与
     *
     * @param n 数字
     * @return 二进制1的个数
     */
    public static int fun1(int n) {
        int ans = 0;
        // 比对每一位
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == (1 << i)) {
                ans++;
            }
        }
        return ans;
    }


}
