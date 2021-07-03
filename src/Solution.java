import java.util.*;

class CharCount {

    public int count;

    public char ch;

    /**
     * 获取输出字符
     *
     * @return 输出字符
     */
    public String getOutputData() {
        StringBuilder outData = new StringBuilder();
        for (int i = 0; i < count; i++) {
            outData.append(ch);
        }
        return outData.toString();
    }

}

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
        System.out.println(new Solution().frequencySort("cccaaa"));
        System.out.println(new Solution().frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        if (Objects.isNull(s) || s.trim().length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> characterMap = new HashMap<>();
        // 统计字符个数
        for (char ch : chars) {
            Integer count = characterMap.get(ch);
            if (Objects.nonNull(count)) {
                characterMap.put(ch, count + 1);
            } else {
                characterMap.put(ch, 1);
            }
        }
        Set<Character> characterSet = characterMap.keySet();
        List<CharCount> charCounts = new ArrayList<>();
        for (Character ch : characterSet) {
            CharCount charCount = new CharCount();
            charCount.ch = ch;
            charCount.count = characterMap.get(ch);
            charCounts.add(charCount);
        }
        // 按照字符个数降序排序
        Collections.sort(charCounts, new Comparator<CharCount>() {
            @Override
            public int compare(CharCount o1, CharCount o2) {
                return o2.count - o1.count;
            }
        });
        StringBuilder ans = new StringBuilder();
        for (CharCount charCount : charCounts) {
            ans.append(charCount.getOutputData());
        }
        return ans.toString();
    }


}
