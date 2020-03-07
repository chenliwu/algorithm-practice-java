package huawei_online_algorithm;

import java.util.*;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 进制转换 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 16进制转为10进制的映射值
        Map<String, Integer> hex2DexMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hex2DexMap.put(String.valueOf(i), i);
        }
        char ch = 'A';
        for (int i = 10; i <= 15; i++) {
            hex2DexMap.put(String.valueOf(ch++), i);
        }

        while (scanner.hasNext()) {
            String hexString = scanner.nextLine();
            hexString = hexString.replace("0x", "");
            char[] chars = hexString.toCharArray();
            int pos = 0;
            int len = chars.length;
            long ans = 0;
            for (int i = len - 1; i >= 0; i--) {
                // hex2DexMap.get(String.valueOf(chars[i])): 快速将16进制转为10进制的数字，乘以权值，就可计算10进制
                ans += hex2DexMap.get(String.valueOf(chars[i])) * getMul(pos++, 16);
            }
            System.out.println(ans);
        }
    }

    /**
     * 根据位置获取进制的权值，从右往左
     *
     * @param position
     * @param jz
     * @return
     */
    public static long getMul(int position, int jz) {
        long mul = 1;
        for (int i = 0; i < position; i++) {
            mul = mul * jz;
        }
        return mul;
    }

}
