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
        // 所有节点的相关域设置为初始值-1
        for (int i = 0; i < 2 * n - 1; i++) {
            hfmTrees[i].parent = hfmTrees[i].left = hfmTrees[i].right = -1;
        }
        int min1, min2;
        int lnode, rnode;

        // 构造哈夫曼树: 非叶子节点ht[i]（存放在ht[n]~ht[2n-2]中），叶子节点存储在ht[0]~ht[n-1]
        for (int i = n; i < 2 * n - 1; i++) {
            min1 = 32767;
            min2 = 32767;
            // lnode和rnode为权值最小的两个节点的位置（即在数组当中的下标）
            lnode = rnode = -1;
            // 在ht[]中寻找权值最小的两个节点
            for (int j = 0; j <= i - 1; j++) {
                // 只在尚未构造二叉树的节点中查找
                if (hfmTrees[j].parent == -1) {
                    if (hfmTrees[j].weight < min1) {    // min1总是记录最小权值的值，min2总是记录权值第二小的值
                        min2 = min1;
                        rnode = lnode;
                        min1 = hfmTrees[j].weight;
                        lnode = j;
                    } else if (hfmTrees[j].weight < min2) {
                        min2 = hfmTrees[j].weight;
                        rnode = j;
                    }
                }
            }
            // 根节点的权值等于左右子树的权值之和
            hfmTrees[i].weight = hfmTrees[lnode].weight + hfmTrees[rnode].weight;
            // ht[i]作为双亲节点
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
