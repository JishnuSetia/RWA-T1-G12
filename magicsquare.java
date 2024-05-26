import java.util.*;

public class magicsquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("Enter square dimension(odd number n):");
            n = sc.nextInt();
            if (n % 2 == 1) {
                break;
            }
        }
        sc.close();
        int[][] arr = createMagicSquare(n, 1);
        int[][] arr2 = createMagicSquare2(n);
        printMagicSquare(arr);
        System.out.println();
        printMagicSquare(arr2);
        System.out.println("Diagonal Sum = " + calculateDiagonalSum(arr));
        System.out.println(isMagicSquare(arr));
        System.out.println(isMagicSquare2(arr));
        arr[0][1] = 8;
        printMagicSquare(arr);
        System.out.println(isMagicSquare2(arr));
        System.out.println(isSquare(arr));
    }

    private static int[][] createMagicSquare(int n, int y) {
        int[][] arr = new int[n][n];
        int[] pos = { ((n + 1) / 2) - 1, 0 };
        for (int i = 1; i <= n * n; i++) {
            arr[pos[1]][pos[0]] = (i - 1) + y;
            pos = calculateNextPosition(n, pos[0], pos[1], arr);
        }
        return arr;
    }

    private static boolean isSquare(int[][] arr) {
        return arr.length == arr[0].length && arr.length % 2 == 1;
    }

    public static int[][] createMagicSquare2(int n){
        int[][] arr = new int[n][n];
        int row=0;
        int col=n/2;
        int z=1;
        arr[row][col]=z;
        for(;z<n*n;){
            z=z+1;
            row=row-1;
            col = col+1;
            if(row<0&&col!=n){
                row = n-1;
            }else if(row>=0&&col==n){
                col=0;
            }else if(row<0&&col==n||arr[row][col]!=0){
                row=row+2;
                col-=1;
            }
            arr[row][col]=z;
        }
        return arr;
    }

    private static int calculateDiagonalSum(int[][] arr) {
        int sum = 0;
        if (isSquare(arr)) {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][i];
            }
        }
        return sum;
    }

    private static boolean isMagicSquare(int[][] arr) {
        if (isSquare(arr)) {
            int[][] chk = createMagicSquare(arr.length, 1);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (chk[i][j] != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isMagicSquare2(int[][] arr) {
        if (isSquare(arr)) {
            int[][] chk = createMagicSquare(arr.length, arr[0][((arr.length + 1) / 2)-1]);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (chk[i][j] != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static void printMagicSquare(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static int[] calculateNextPosition(int n, int x_pos, int y_pos, int[][] arr) {

        int x = x_pos + 1;
        int y = y_pos - 1;
        if (y < 0) {
            y = n - 1;
        }
        if (x >= n) {
            x = 0;
        }
        if (arr[y][x] != 0) {
            x = x_pos;
            y = y_pos + 1;
        }
        int[] newPos = { x, y };
        return newPos;
    }
}
