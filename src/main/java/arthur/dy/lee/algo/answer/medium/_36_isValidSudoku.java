package arthur.dy.lee.algo.answer.medium;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 */
public class _36_isValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];  // 哈希表存储每一行的每个数是否出现过，默认初始情况下，每一行每一个数都没有出现过
        // 整个board有9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
        int[][] col = new int[9][10];  // 存储每一列的每个数是否出现过，默认初始情况下，每一列的每一个数都没有出现过
        int[][] box = new int[9][10];  // 存储每一个box的每个数是否出现过，默认初始情况下，在每个box中，每个数都没有出现过。整个board有9个box。
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {// 遍历到第i行第j列的那个数,我们要判断这个数在其所在的行有没有出现过，
                // 同时判断这个数在其所在的列有没有出现过
                // 同时判断这个数在其所在的box中有没有出现过
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '0';
                if (row[i][curNum] == 1) {
                    return false;
                }
                if (col[j][curNum] == 1) {
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][curNum] == 1) {
                    return false;
                }
                row[i][curNum] = 1;
                col[j][curNum] = 1;
                box[j / 3 + (i / 3) * 3][curNum] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //        char[][] table1 = {
        //                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        //                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        //                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        //                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        //                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        //                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        //                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        //                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        //                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        //        };
        //        System.out.println(_36_isValidSudoku.isValidSudoku(table1));

        char[][] table2 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(_36_isValidSudoku.isValidSudoku(table2));
    }
}
