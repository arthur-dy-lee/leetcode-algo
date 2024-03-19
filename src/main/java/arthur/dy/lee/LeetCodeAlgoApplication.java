package arthur.dy.lee;

//@SpringBootApplication(scanBasePackages = "com.arthur.dy.lee")
public class LeetCodeAlgoApplication {

    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.get();
        threadLocal.set(new Integer(1));
        Thread thread = new Thread();

    }
}
