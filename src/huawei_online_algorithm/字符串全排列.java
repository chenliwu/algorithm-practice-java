package huawei_online_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author chenlw
 * @since 2020-11-15
 */
public class 字符串全排列 {

    public static void main(String[] args) {
        List<String> dataList = new 字符串全排列().Permutation("ABC");
        dataList.stream().forEach((data) -> {
            System.out.println(data);
        });
    }

    public ArrayList<String> Permutation(String str) {
        // 使用TreeSet集合来排序和去重
        Set<String> stringTreeSet = new TreeSet<>();
        perm(0, str.toCharArray(), stringTreeSet);
        return new ArrayList<>(stringTreeSet);
    }

    public void perm(int pos, char[] chars, Set<String> stringTreeSet) {
        if (pos + 1 == chars.length) {
            // 递归终止条件：当pos+1 == s.length()的时候，终止，表示对最后一个字符进行固定，也就说明，完成了一次全排列
            stringTreeSet.add(String.valueOf(chars));
            return;
        }
        // for循环和swap的含义：对于“ABC”，
        // 第一次'A' 与 'A'交换，字符串为"ABC", pos为0， 相当于固定'A'
        // 第二次'A' 与 'B'交换，字符串为"BAC", pos为0， 相当于固定'B'
        // 第三次'A' 与 'C'交换，字符串为"CBA", pos为0， 相当于固定'C'
        for (int i = pos; i < chars.length; ++i) {
            swap(chars, pos, i);
            perm(pos + 1, chars, stringTreeSet);
            swap(chars, pos, i);
            // 回溯的原因：比如第二次交换后是"BAC"，需要回溯到"ABC"
            // 然后进行第三次交换，才能得到"CBA"
        }
    }

    public void swap(char[] chars, int pos1, int pos2) {
        char temp = chars[pos1];
        chars[pos1] = chars[pos2];
        chars[pos2] = temp;
    }

}
