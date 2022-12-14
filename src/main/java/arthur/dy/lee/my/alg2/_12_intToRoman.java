package arthur.dy.lee.my.alg2;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 提示：
 * 1 <= num <= 3999
 */
public class _12_intToRoman {
    public static String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        while (num > 0) {
            if (num / 1000 >= 1) {
                num -= 1000;
                ret.append("M");
            } else if (num / 900 == 1) {
                num -= 900;
                ret.append("CM");
            } else if (num / 500 >= 1) {
                num -= 500;
                ret.append("D");
            } else if (num / 400 == 1) {
                num -= 400;
                ret.append("CD");
            } else if (num / 100 >= 1) {
                num -= 100;
                ret.append("C");
            } else if (num / 90 == 1) {
                num -= 90;
                ret.append("XC");
            } else if (num / 50 >= 1) {
                num -= 50;
                ret.append("L");
            } else if (num / 40 == 1) {
                num -= 40;
                ret.append("XL");
            } else if (num / 10 >= 1) {
                num -= 10;
                ret.append("X");
            } else if (num / 9 == 1 && (num % 9 == 0)) {
                num = 0;
                ret.append("IX");
            } else if (num / 5 >= 1) {
                num -= 5;
                ret.append("V");
            } else if (num / 4 == 1 && (num % 4 == 0)) {
                num = 0;
                ret.append("IV");
            } else if (num >= 1) {
                num--;
                ret.append("I");
            }

        }
        return ret.toString();
    }

    public static void main(String[] args) {
        int num = 0;
        num = 3;
        System.out.println(_12_intToRoman.intToRoman(num));
        num = 4;
        System.out.println(_12_intToRoman.intToRoman(num));
        num = 9;
        System.out.println(_12_intToRoman.intToRoman(num));
        num = 58;
        System.out.println(_12_intToRoman.intToRoman(num));
        num = 1994;
        System.out.println(_12_intToRoman.intToRoman(num));

    }
}
