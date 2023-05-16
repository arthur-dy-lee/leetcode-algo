package arthur.dy.lee.algo.blank.medium;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 提示：Z
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class _43_multiply {
    public static String multiply(String num1, String num2) {
        return "0";
    }

    private static String addString(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = x + y + carry;
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println(_43_multiply.multiply(num1, num2));  //56088

        num1 = "99";
        num2 = "9";
        System.out.println(_43_multiply.multiply(num1, num2));  //891

        num1 = "9";
        num2 = "9";
        System.out.println(_43_multiply.multiply(num1, num2));

        num1 = "881095803";
        num2 = "61";
        System.out.println(_43_multiply.multiply(num1, num2));  //53746843983
    }
}
