package arthur.dy.lee.answer.medium;

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
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0
                || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        String res = "0";
        for (int j = len2 - 1; j >= 0; j--) {
            StringBuilder curr = new StringBuilder();
            for (int i = 0; i < len2 - 1 - j; i++) {
                curr.append("0");
            }
            int x = num2.charAt(j) - '0';
            int carry = 0;
            for (int i = len1 - 1; i >= 0 || carry > 0; i--) {
                int y = i < 0 ? 0 : num1.charAt(i) - '0';
                int tmp = x * y + carry;
                carry = tmp / 10;
                curr.append(tmp % 10);
                System.out.println("curr=" + curr);
            }

            res = addString(res, curr.reverse().toString());
            System.out.println("res = " + res);
        }

        return res;
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
