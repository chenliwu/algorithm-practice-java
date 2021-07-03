package string;

import java.util.*;

/**
 * @author chenlw 2021-06-09
 * @since 1.0.0
 */
public class 全排列 {

    public static void main(String[] args) {
        String str = "abc";
        String[] strs = permutation(str);
        for (String string : strs) {
            System.out.println(string);
        }
    }

    public static String[] permutation(String string) {
        Set<String> stringTreeSets = new HashSet<>();
        perm(0, string.toCharArray(), stringTreeSets);
        String[] ans = new String[stringTreeSets.size()];
        int index = 0;
        for (String str : stringTreeSets) {
            ans[index++] = str;
        }
        return ans;
    }


    public static void perm(int pos, char[] chars, Set<String> stringTreeSets) {
        if (pos + 1 == chars.length) {
            // 递归出口
            stringTreeSets.add(String.valueOf(chars));
            return;
        }
        for (int i = pos; i < chars.length; i++) {
            // 交换位置pos和i的位置
            swap(chars, pos, i);
            perm(pos + 1, chars, stringTreeSets);
            // 位置复原
            swap(chars, pos, i);
        }
    }

    public static void swap(char[] chars, int pos1, int pos2) {
        char temp = chars[pos1];
        chars[pos1] = chars[pos2];
        chars[pos2] = temp;
    }

}
