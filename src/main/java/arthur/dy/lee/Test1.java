package arthur.dy.lee;

public class Test1 {
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if ('a' == tmp) {
                if (i <= s.length() - 3 && 'a' == s.charAt(i + 1)
                        && 'a' == s.charAt(i + 2)) {
                    return -1;
                } else if (i <= s.length() - 2 && 'a' == s.charAt(i + 1)) {
                    i = i + 2;
                } else {
                    res++;
                }
            } else {
                if (i > 0 && s.charAt(i - 1) == 'a') {
                    continue;
                }
                res = res + 2;
            }

        }
        if ((s.charAt(s.length() - 1) != 'a')) {
            res = res + 2;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println('a' == s.charAt(0));
        s = "aabab";
        System.out.println(3 == Test1.solution(s));
        s = "dog";
        System.out.println(8 == Test1.solution(s));
        s = "aa";
        System.out.println(0 == Test1.solution(s));
        s = "baaaa";
        System.out.println(-1 == Test1.solution(s));
    }
}
