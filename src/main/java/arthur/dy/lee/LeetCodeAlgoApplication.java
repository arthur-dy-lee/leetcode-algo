package arthur.dy.lee;

//@SpringBootApplication(scanBasePackages = "com.arthur.dy.lee")
public class LeetCodeAlgoApplication {

    public static void main(String[] args) {
        int i = 3;

        System.out.println("-----" + (++i));
        System.out.println("-----" + i++);
        for (i = 0; i < 3; i++) {
            System.out.println(i);
        }
        for (i = 0; i < 3; ++i) {
            System.out.println(i);
        }
    }
}
