import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n <= 0) {
                return;
            }
            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            output(solution(a,n));

        }

//        int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int n = 4;
//        output(solution(a, n));
    }

    public static void output(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int a[][], int n) {
        int b[][] = new int[n][n];
        for (int startRow = 0; startRow < n; startRow++) {
            for (int i = 0; i < n; i++) {
                b[i][n - startRow - 1] = a[startRow][i];
            }
        }
        return b;
    }


}
