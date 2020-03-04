import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int scores[] = new int[30001];
            int N, M;
            N = scanner.nextInt();
            M = scanner.nextInt();
            for (int i = 1; i <= N; i++) {
                scores[i] = scanner.nextInt();
            }
            int a, b;
            String s1, s2, s3;
            // scanner.nextLine();
            for (int i = 0; i < M; i++) {
                s1 = scanner.next();
                s2 = scanner.next();
                s3 = scanner.next();
                // System.out.println(s1 + "---" + s2 + "---" + s3);

                a = Integer.parseInt(s2);
                b = Integer.parseInt(s3);
                if ("Q".equals(s1)) {
                    query(scores, N, a, b);
                } else if ("U".equals(s1)) {
                    update(scores, N, a, b);
                }
            }


        }
    }

    /**
     * 询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
     *
     * @param scores
     * @param len
     * @param a
     * @param b
     */
    public static void query(int scores[], int len, int a, int b) {
        System.out.println(getHigh(scores, len, a, b));
    }

    public static int getHigh(int scores[], int len, int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        // System.out.println("getHigh:["+a+","+b+"]");
        int mmax = scores[a];
        for (int i = a + 1; i <= b; i++) {
            if (mmax < scores[i]) {
                mmax = scores[i];
            }
        }
        return mmax;
    }

    public static void update(int scores[], int len, int index, int updateScore) {
        if (index >= 1 && index <= len) {
            scores[index] = updateScore;
        }
//        System.out.println("update");
//        for (int i = 1; i <= len; i++) {
//            System.out.print(scores[i] + " ");
//        }
//        System.out.println("");
    }

}
