package huawei_online_algorithm;

import java.util.*;

/**
 * 哈夫曼编码
 *
 * @author chenlw
 * @date 2020/03/07
 */
public class 哈夫曼编码 {

    static class HFMTree {
        public String data;
        public int weight;
        public int parent;
        public int left;
        public int right;
    }

    static class HCode {
        public char cd[] = new char[200];
        public int start;
        public String data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char[] chars = string.toCharArray();

        Set<String> charSet = new HashSet<>();
        for (char ch : chars) {
            charSet.add(String.valueOf(ch));
        }
        int n = charSet.size();
        List<HFMTree> hfmTreeList = new ArrayList<>(n * 2);

        HFMTree[] hfmTrees = new HFMTree[n * 2 - 1];
        for (String ch : charSet) {
            HFMTree hfmTree = new HFMTree();
            hfmTree.data = ch;
            hfmTree.weight = getCharNumber(ch, chars);
            hfmTreeList.add(hfmTree);
        }

        int i = 0;
        for (HFMTree hfmTree : hfmTreeList) {
            hfmTrees[i++] = hfmTree;
        }
        for (int j = i; j < n * 2 - 1; j++) {
            hfmTrees[j] = new HFMTree();
        }

        createdHFMTree(hfmTrees, n);

        List<HCode> hCodeList = new ArrayList<>();
        createHcode(hfmTrees, hCodeList, n);


        Map<String, HCode> hCodeMap = new HashMap<>();
        for (HCode hCode : hCodeList) {
            hCodeMap.put(hCode.data, hCode);
            // output(hCode);
        }


        for (char ch : chars) {
            HCode hCode = hCodeMap.get(String.valueOf(ch));
            if (hCode != null) {
                output(hCode);
            }
        }
        System.out.println();

//        for (HFMTree hfmTree : hfmTrees) {
//            System.out.println(hfmTree.weight + "---" + hfmTree.data);
//        }

//        for (HFMTree hfmTree:hfmTreeList){
//            System.out.println(hfmTree.data+"---"+hfmTree.weight);
//        }

    }

    public static void output(HCode hCode) {
        char[] outs = hCode.cd;
        for (char ch : outs) {
            if (ch != '\u0000') {
                System.out.print(ch);
            }
        }
    }

    /**
     * 根据哈夫曼树求对应的哈夫曼编码
     *
     * @param hfmTrees
     * @param hCodeList
     * @param n
     */
    public static void createHcode(HFMTree[] hfmTrees, List<HCode> hCodeList, int n) {
        int i, f, c;
        for (i = 0; i < n; i++) {
            HCode hCode = new HCode();
            hCode.start = n;
            hCode.data = hfmTrees[i].data;
            c = i;
            f = hfmTrees[i].parent;
            while (f != -1) {
                if (hfmTrees[f].left == c) {
                    hCode.cd[hCode.start--] = '0';
                } else {
                    hCode.cd[hCode.start--] = '1';
                }

                c = f;
                f = hfmTrees[f].parent;
            }
            hCode.start++;
            hCodeList.add(hCode);
        }
    }

    /**
     * 构造哈夫曼树
     *
     * @param hfmTrees
     * @param n
     */
    public static void createdHFMTree(HFMTree[] hfmTrees, int n) {
        int i, j, k;
        int min1, min2;
        int lnode, rnode;

        for (i = 0; i < 2 * n - 1; i++) {
            hfmTrees[i].parent = hfmTrees[i].left = hfmTrees[i].right = -1;
        }

        for (i = n; i < 2 * n - 1; i++) {
            min1 = 32767;
            min2 = 33767;
            lnode = rnode = -1;
            for (k = 0; k <= i - 1; k++) {
                if (hfmTrees[k].parent == -1) {
                    if (hfmTrees[k].weight < min1) {
                        min2 = min1;
                        rnode = lnode;
                        min1 = hfmTrees[k].weight;
                        lnode = k;
                    } else if (hfmTrees[k].weight < min2) {
                        min2 = hfmTrees[k].weight;
                        rnode = k;
                    }
                }
            }
            hfmTrees[i].weight = hfmTrees[lnode].weight + hfmTrees[rnode].weight;
            hfmTrees[i].left = lnode;
            hfmTrees[i].right = rnode;
            hfmTrees[lnode].parent = i;
            hfmTrees[rnode].parent = i;
        }
    }

    public static int getCharNumber(String ch, char[] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (ch.equals(String.valueOf(chars[i]))) {
                count++;
            }
        }
        return count;
    }

}
