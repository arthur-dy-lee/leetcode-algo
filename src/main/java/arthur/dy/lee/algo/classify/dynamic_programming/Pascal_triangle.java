package arthur.dy.lee.classify.dynamic_programming;

import java.util.Arrays;

/**
 * “杨辉三角”不知道你听说过吗？我们现在对它进行一些改造。每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 * <p>
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。请你编程求出从最高层移动到最底层的最短路径长度。
 */
public class Pascal_triangle {
    /**
     * 仅参考
     *
     * @param matrix
     * @return
     */
    public static int yanghuiTriangle(int[][] matrix) {
        int[][] state = new int[matrix.length][matrix.length];
        state[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0)
                    state[i][j] = state[i - 1][j] + matrix[i][j];
                else if (j == matrix[i].length - 1)
                    state[i][j] = state[i - 1][j - 1] + matrix[i][j];
                else {
                    int top1 = state[i - 1][j - 1];
                    int top2 = state[i - 1][j];
                    state[i][j] = Math.min(top1, top2) + matrix[i][j];
                }
            }
        }
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[matrix.length - 1].length; i++) {
            int distance = state[matrix.length - 1][i];
            if (distance < minDis)
                minDis = distance;
        }
        return minDis;
    }

    public static void dynamic2(int[][] triangle, int n) {
        int[] res = new int[n];
        res[0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            // 倒着遍历，取一个上一层的j，置空，就不会影响遍历了。
            for (int j = i - 1; j >= 0; j--) {
                //上一层的
                int up = res[j];
                res[j] = 0; //因为是上一层的，所以置空
                int t_j = triangle[i][j];
                // f(i,j)
                if (res[j] == 0 || res[j] > up + t_j)
                    res[j] = up + t_j;
                t_j = triangle[i][j + 1];
                // f(i,j+1)
                if (res[j + 1] == 0 || res[j] > up + t_j) {
                    res[j + 1] = up + t_j;
                }
            }
            System.out.println(Arrays.toString(res));
            System.out.println("===========");
        }
        int min = Integer.MAX_VALUE;
        for (int i : res) {
            if (i < min)
                min = i;
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 5 }, { 7, 8 }, { 2, 3, 4 }, { 4, 9, 6, 1 }, { 2, 7, 9, 4, 5 } };
        System.out.println(Pascal_triangle.yanghuiTriangle(matrix));

        int[][] yangHuiTriangle = { { 5 }, { 7, 8 }, { 2, 3, 4 }, { 4, 9, 6, 1 }, { 2, 7, 9, 4, 5 } };
        //        System.out.println(Pascal_triangle.dynamic2(yangHuiTriangle));
    }
}
