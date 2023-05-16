package arthur.dy.lee.algo.blank.medium;

import cn.hutool.json.JSONUtil;

/**
 * 48. 旋转图像
 * 有图更好理解
 * https://leetcode.cn/problems/rotate-image/
 * <p>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 提示：
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class _48_rotate {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < n; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - i][j];
//                matrix[n - 1 - i][j] = tmp;
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }

        System.out.println("after rotate1:\n" + JSONUtil.toJsonStr(matrix));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

    public static void main(String[] args) {

        int[][] matrix2 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(matrix2.length);
        System.out.println("before rotate:\n" + JSONUtil.toJsonStr(matrix2));
        _48_rotate.rotate(matrix2);
        System.out.println("after rotate:\n" + JSONUtil.toJsonStr(matrix2));

        //        int[][] matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        //        System.out.println("before rotate:\n" + JSONUtil.toJsonStr(matrix));
        //        _48_rotate.rotate(matrix);
        //        System.out.println("after rotate:\n" + JSONUtil.toJsonStr(matrix));
    }
}
