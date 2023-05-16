package arthur.dy.lee.algo.answer.medium;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * 看图请看problems.md文件
 */
public class _79_world_exist {
    public static final int[][]     DIRECTIONS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    private             int         rows;
    private             int         cols;
    private             int         len;
    private             boolean[][] visited;
    private             char[]      charArray;
    private             char[][]    board;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        visited = new boolean[rows][cols];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        for (int[] direction : DIRECTIONS) {
            System.out.println("direction[0]=" + direction[0] + ", direction[1]=" + direction[1]);
        }

        _79_world_exist exist = new _79_world_exist();
        //        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        //        String word = "ABCCED";
        //        System.out.println(Boolean.TRUE.equals(exist.exist(board, word)));
        //
        //        exist = new _79_world_exist();
        //        char[][] board2 = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        //        String word2 = "SEE";
        //        System.out.println(Boolean.TRUE.equals(exist.exist(board2, word2)));
        //
        //        exist = new _79_world_exist();
        //        char[][] board3 = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        //        String word3 = "ABCB";
        //        System.out.println(Boolean.FALSE.equals(exist.exist(board3, word3)));
        //
        //        exist = new _79_world_exist();
        //        char[][] board4 = new char[][] { { 'a', 'b' } };
        //        String word4 = "ba";
        //        System.out.println(Boolean.TRUE.equals(exist.exist(board4, word4)));

        //        exist = new _79_world_exist();
        //        char[][] board5 = new char[][] { { 'a', 'a', 'b', 'a', 'a', 'b' }, { 'a', 'a', 'b', 'b', 'b', 'a' },
        //                { 'a', 'a', 'a', 'a', 'b', 'a' }, { 'b', 'a', 'b', 'b', 'a', 'b' }, { 'a', 'b', 'b', 'a', 'b', 'a' },
        //                { 'b', 'a', 'a', 'a', 'a', 'b' } };
        //        String word5 = "bbbaabbbbbab";
        //        System.out.println(Boolean.TRUE.equals(exist.exist(board5, word5)));

        exist = new _79_world_exist();
        char[][] board6 = new char[][] { { 'a', 'a', 'a', 'a' }, { 'a', 'a', 'a', 'a' }, { 'a', 'a', 'a', 'a' } };
        String word6 = "aaaaaaaaaaaaa";
        System.out.println(Boolean.TRUE.equals(exist.exist(board6, word6)));

    }

}
