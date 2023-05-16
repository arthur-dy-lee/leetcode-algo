package arthur.dy.lee.algo.blank.medium;

/**
 * 917. 仅仅反转字母
 * 简单
 * <p>
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 * <p>
 * 示例 1：
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * 提示
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 */
public class _917_reverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();

        return new String(arr);
    }

    public static void main(String[] args) {
        String s1 = "ab-cd";
        System.out.println("dc-ba".equals(_917_reverseOnlyLetters.reverseOnlyLetters(s1)));
        String s2 = "Test1ng-Leet=code-Q!";
        System.out.println("Qedo1ct-eeLg=ntse-T!".equals(_917_reverseOnlyLetters.reverseOnlyLetters(s2)));

        String s3 = "7_28]";
        System.out.println("7_28]".equals(_917_reverseOnlyLetters.reverseOnlyLetters(s3)));
    }
}
