import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            System.out.println(n - fun(n));

//            String input = scanner.nextLine();
//            String[] strings = input.split(",");
//            int m = Integer.parseInt(strings[0]);
//            int n = Integer.parseInt(strings[1]);
//            int x1 = Integer.parseInt(strings[2]);
//            int y1 = Integer.parseInt(strings[3]);
//            int x2 = Integer.parseInt(strings[4]);
//            int y2 = Integer.parseInt(strings[5]);
//            int[][] jz = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    jz[i][j] = 0;
//                }
//            }
//            jz[x1][y1] = 1;
//            jz[x2][y2] = 1;
//            kuosanFun(m, n, jz);


            String input = scanner.nextLine();
            String[] strings = input.split(",");
            int num = strings.length;
            int n = 1;
            for (int i = 1; i <= 200; i++) {
                if (i * i == num) {
                    n = i;
                    break;
                }
            }
            int[][] dt = new int[n][n];
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dt[i][j] = Integer.parseInt(strings[k++]);
                }
            }
            System.out.println(ganranFun(n, dt));
        }
    }

    /**
     * 判断是否全部感染
     *
     * @param n
     * @param dt
     * @return
     */
    public static boolean isAllGanran(int n, int[][] dt) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dt[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断是否全部未感染
     *
     * @param n
     * @param dt
     * @return
     */
    public static boolean isAllNotGanran(int n, int[][] dt) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dt[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int ganranFun(int n, int[][] dt) {
        if (isAllGanran(n, dt) || isAllNotGanran(n, dt)) {
            return -1;
        }
        int[][] dtCopy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dtCopy[i][j] = dt[i][j];
            }
        }
        int ans = 0;
        while (true) {
            ans++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dt[i][j] == 1) {
                        // 在复制矩阵中修改值
                        if (i + 1 < n) {
                            dtCopy[i + 1][j] = 1;
                        }
                        if (i - 1 >= 0) {
                            dtCopy[i - 1][j] = 1;
                        }
                        if (j + 1 < n) {
                            dtCopy[i][j + 1] = 1;
                        }
                        if (j - 1 >= 0) {
                            dtCopy[i][j - 1] = 1;
                        }
                    }
                }
            }
            // 将修改后的复制矩阵赋值回来
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dt[i][j] = dtCopy[i][j];
                }
            }
            if (isAllGanran(n, dt)) {
                break;
            }
        }
        return ans;
    }


    public static void kuosanFun(int m, int n, int[][] jz) {
        int[][] jzCopy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                jzCopy[i][j] = jz[i][j];
            }
        }
        int ans = 0;
        while (true) {
            ans++;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (jz[i][j] == 1) {
                        // 在复制矩阵中修改值
                        if (i + 1 < m) {
                            jzCopy[i + 1][j] = 1;
                        }
                        if (i - 1 >= 0) {
                            jzCopy[i - 1][j] = 1;
                        }
                        if (j + 1 < n) {
                            jzCopy[i][j + 1] = 1;
                        }
                        if (j - 1 >= 0) {
                            jzCopy[i][j - 1] = 1;
                        }
                    }
                }
            }
            // 将修改后的复制矩阵赋值回来
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    jz[i][j] = jzCopy[i][j];
                }
            }
            // 判断是否还有0, 默认没有，只要有一个0，就继续循环
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (jz[i][j] == 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                break;
            }

        }
        System.out.println(ans);
    }


    // 统计n以内有4的数字个数
    public static int fun(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (String.valueOf(i).contains("4")) {
                ans++;
            }
        }
        System.out.println("n以内有4的数字个数:" + ans);
        return ans;
    }

    public static int[] arr4 = {0, 1, 19, 271, 3439, 40951, 468559, 5217031, 56953279};
    public static int[][] ds = new int[10][10];

    // 统计n以内有4的数字个数
    public static int fun1(int n) {
        int ans = 0;
        // 计算n内的数字4的个数
        String str = String.valueOf(n);
        int len = str.length();
        for (int i = 1; i <= 8; i++) {
            for (int j = 0; j <= 9; j++) {
                //ds[i][j] =
            }
        }
//        if (len == 1) {
//            return fun(n);
//        } else {
//            // 个位/十位，表示
//            int jwFlag = len - 1;
//            int index = 0;
//            int num = Integer.parseInt(String.valueOf(str.charAt(index)));
//            if (num >= 4) {
//
//            }
//        }
        return ans;
    }


}