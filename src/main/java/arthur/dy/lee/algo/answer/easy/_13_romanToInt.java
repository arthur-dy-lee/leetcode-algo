package arthur.dy.lee.algo.answer.easy;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 */
public class _13_romanToInt {

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ret = 0;
        int pre = getVal(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = getVal(s.charAt(i));
            if (pre < cur) {
                ret = ret - pre;
            } else {
                ret = ret + pre;
            }
            pre = cur;
        }
        ret += pre;
        return ret;
    }

    private static int getVal(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        String s = "";
        s = "III";
        System.out.println(_13_romanToInt.romanToInt(s));
        s = "IV";
        System.out.println(_13_romanToInt.romanToInt(s));
        s = "IX";
        System.out.println(_13_romanToInt.romanToInt(s));
        s = "LVIII";
        System.out.println(_13_romanToInt.romanToInt(s));
        s = "MCMXCIV";
        System.out.println(_13_romanToInt.romanToInt(s));
    }
}
