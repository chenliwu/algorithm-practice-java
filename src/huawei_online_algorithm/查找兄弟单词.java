package huawei_online_algorithm;

import java.util.*;

/**
 * @author chenlw
 * @date 2020/03/07
 */
public class 查找兄弟单词 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                stringList.add(scanner.next());
            }
            String findWord = scanner.next();
            int k = scanner.nextInt();

            String []words = stringList.toArray(new String[stringList.size()]);
            process(words,findWord,k);


//            System.out.println(n);
//            for (String str:stringList){
//                System.out.println(str);
//            }
//            System.out.println(findWord);
//            System.out.println(k);
        }
    }

    public static void process(String[] dict, String target, int brotherIndex) {
        ArrayList<String> list = new ArrayList<>();
        Arrays.sort(dict);
        for (String cur : dict) {
            if (isBrother(target, cur)) {
                list.add(cur);
            }
        }
        System.out.println(list.size());
        if (brotherIndex <= list.size() && list.size() > 0) {
            System.out.println(list.get(brotherIndex - 1));
        }
    }

    public static boolean isBrother(String target, String cur) {
        // target can not same as cur
        if (target.equals(cur)) {
            return false;
        }
        // length must be same
        if (target.length() != cur.length()) {
            return false;
        }
        // norm case
        char[] targetArray = target.toCharArray();
        char[] curArray = cur.toCharArray();
        // sortted array must be same
        Arrays.sort(targetArray);
        Arrays.sort(curArray);
        for (int i = 0; i < curArray.length; i++) {
            if (targetArray[i] != curArray[i]) {
                return false;
            }
        }
        return true;
    }

}
