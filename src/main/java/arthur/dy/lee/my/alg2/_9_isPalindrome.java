package arthur.dy.lee.my.alg2;

public class _9_isPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 9 && x >= 0) {
            return Boolean.FALSE;
        }
        if (x < 0) {
            return Boolean.FALSE;
        }
        String s = Integer.toString(x);

        int right = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            Character left = s.charAt(i);
            right = x % 10;
            x = x / 10;
            if ((left - '0') != right) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = -121;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = 10;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = 1221;
        System.out.println(_9_isPalindrome.isPalindrome(x));
        x = 1222;
        System.out.println(_9_isPalindrome.isPalindrome(x));
    }
}
