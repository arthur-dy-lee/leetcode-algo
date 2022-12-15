package arthur.dy.lee.best;

/**
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * <p>
 * 3322251
 * 23321511
 */
public class _38_countAndSay {
    public static String countAndSay(int n) {
        return recursion("1", 1, n);
    }

    private static String recursion(String result, int i, int n) {
        if (n == 1) {
            return "1";
        }
        if (i == n) {
            return result;
        }
        String s = result;
        StringBuilder tmp = new StringBuilder();
        int j = 0;
        while (j <= s.length() - 1) {
            int count = 1;
            Character c = s.charAt(j);
            while (j <= s.length() - 2 && c == s.charAt(j + 1)) {
                count++;
                j++;
            }
            tmp.append(count).append(c);
            j++;
        }
        return recursion(tmp.toString(), i + 1, n);
    }

    public static void main(String[] args) {
        int n5 = 2;
        System.out.println(_38_countAndSay.countAndSay(n5));  //11

        int n6 = 3;
        System.out.println(_38_countAndSay.countAndSay(n6));  //21

        int n4 = 4;
        System.out.println(_38_countAndSay.countAndSay(n4));  //1211

        int n3 = 1;
        System.out.println(_38_countAndSay.countAndSay(n3));  //1

        int n2 = 11;
        System.out.println(_38_countAndSay.countAndSay(n2));  //21

        //        int n1 = 3322251;
        //        System.out.println("23321511".equals(_38_countAndSay.countAndSay(n1)));

    }
}
