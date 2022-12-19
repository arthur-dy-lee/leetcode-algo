package arthur.dy.lee.best.easy;

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
