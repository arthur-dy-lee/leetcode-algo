package arthur.dy.lee.algo.classify.string;

/**
 * 344. 反转字符串
 * 简单
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class _344_reverseString {

    public static void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int begin = 0;
        int end = s.length - 1;
        while (begin < end) {
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            end--;
            begin++;
        }

    }

    public static void main(String[] args) {
        char[] s1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
        _344_reverseString.reverseString(s1);
        StringBuilder res1 = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            res1.append(s1[i]);
        }
        System.out.println("olleh".equals(res1.toString()));
    }
}
