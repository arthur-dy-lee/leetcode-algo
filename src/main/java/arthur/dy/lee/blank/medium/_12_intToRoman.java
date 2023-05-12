package arthur.dy.lee.blank.medium;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<Integer, String> map = new HashMap() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    private static final String[] thousand = new String[] { "M", "MM", "MM" };
    private static final String[] hundred  = new String[] { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    private static final String[] ten      = new String[] { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    private static final String[] digit    = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

    /**
     * 时间复杂度：O(1)。计算量与输入数字的大小无关。
     * 空间复杂度：O(1)。
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        StringBuffer roman = new StringBuffer();
        if (num / 1000 > 0) {
            roman.append(thousand[num / 1000 - 1]);
        }
        int h = num % 1000;
        if ((h / 100) > 0) {
            roman.append(hundred[(h / 100) - 1]);
        }
        int t = h % 100;
        if ((t / 10) > 0) {
            roman.append(ten[(t / 10) - 1]);
        }
        if (t % 10 > 0) {
            roman.append(digit[t % 10 - 1]);
        }
        System.out.println("num=" + num + ", roman=" + roman);
        return roman.toString();
    }

    public static void main(String[] args) {
        int num = 0;
        num = 3;
        System.out.println(_12_intToRoman.intToRoman(num).equals("III"));
        num = 4;
        System.out.println(_12_intToRoman.intToRoman(num).equals("IV"));
        num = 9;
        System.out.println(_12_intToRoman.intToRoman(num).equals("IX"));
        num = 58;
        System.out.println(_12_intToRoman.intToRoman(num).equals("LVIII"));
        num = 1994;
        System.out.println(_12_intToRoman.intToRoman(num).equals("MCMXCIV"));

    }
}
