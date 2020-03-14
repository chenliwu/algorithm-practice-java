package data_structure.string;

/**
 * 字符串匹配
 * 布鲁特-福斯算法。简单模式匹配
 *
 * @author chenlw
 * @date 2020/03/14
 */
public class StringBfMatching {

    public static void main(String[] args) {
        String mainStr="i am chenlw";
        String modeStr = "chenlw";
        System.out.println(index(mainStr.toCharArray(),modeStr.toCharArray()));
    }

    static int index(char[] mainStr, char[] modeStr) {
        int mainStrLen = mainStr.length;
        int modeStrLen = modeStr.length;
        int i = 0, j = 0;
        while (i < mainStrLen && j < modeStrLen) {
            if (mainStr[i] == modeStr[j]) {
                i++;
                j++;
            } else {
                // 主串指针回溯
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= modeStrLen) {
            // 匹配成功，返回模式串在主串的起始下标
            return i - modeStrLen;
        }
        return -1;
    }

}
