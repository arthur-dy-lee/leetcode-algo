package arthur.dy.lee.pattern.creational.singleton.lazy;

/**
 * 双重检测锁模式存在问题，在多线程的情况下，可能会出现空指针问题，出现问题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作。
 * 当某个线程获取锁进行实例化时，其他线程就直接获取实例使用，由于JVM指令重排序的原因，其他线程获取的对象也许不是一个完整的对象，所以在使用实例的时候就会出现空指针异常问题。
 * 要解决双重检查锁模式带来空指针异常的问题，只需要使用volatile关键字，volatile关键字严格遵循happens-before原则，即在读操作前，写操作必须全部完成。
 *
 */
public class LazyDoubleCheckSingleton {

    /**
     *  instance 成员变量加上 volatile 关键字，从而禁止指令重排序。而高版本的 Java 已在 JDK 内部解决了这个问题，所以高版本的 Java 不需要关注这个问题？
     */
    private static volatile LazyDoubleCheckSingleton singleton = null;

    private LazyDoubleCheckSingleton() {
    }

    private static LazyDoubleCheckSingleton getInstance() {
        if (singleton == null) {
            /**
             * 为了在多线程环境下，不影响程序的性能，不让线程每次调用getInstanceC()方法时都加锁，
             * 而只是在实例未被创建时再加锁，在加锁处理里面还需要判断一次实例是否已存在。
             */
            synchronized (LazyDoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        LazyDoubleCheckSingleton singleton1 = LazyDoubleCheckSingleton.getInstance();
        LazyDoubleCheckSingleton singleton2 = LazyDoubleCheckSingleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
