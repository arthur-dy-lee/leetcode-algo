package arthur.dy.lee.algo.blank.medium;

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
public class _38_countAndSay_2 {
    public static String countAndSay(int n) {

        return "";
    }

    public static void main(String[] args) {
        int n5 = 2;
        System.out.println(_38_countAndSay_2.countAndSay(n5));  //11

        int n6 = 3;
        System.out.println(_38_countAndSay_2.countAndSay(n6));  //21

        int n4 = 4;
        System.out.println(_38_countAndSay_2.countAndSay(n4));  //1211

        int n3 = 1;
        System.out.println(_38_countAndSay_2.countAndSay(n3));  //1

        int n2 = 11;
        System.out.println(_38_countAndSay_2.countAndSay(n2));  //21

    }
}
