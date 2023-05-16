package arthur.dy.lee.pattern.creational.singleton.lazy;

/**
 * 静态内部类单例模式也称单例持有者模式，实例由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的,
 * 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性。静态属性由static修饰，保证只被实例化一次，并且严格保证实例化顺序。
 *
 * 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。
 *
 * 总结：
 * 优势：兼顾了懒汉模式的内存优化（使用时才初始化）以及饿汉模式的安全性（不会被反射入侵）。
 * 劣势：需要两个类去做到这一点，虽然不会创建静态内部类的对象，但是其 Class 对象还是会被创建，而且是属于永久带的对象。
 */
public class LazyStaticSingleton {

    private LazyStaticSingleton() {
    }

    public static LazyStaticSingleton getInstance() {
        return LazyStaticSingletonHolder.singleton;
    }

    private static class LazyStaticSingletonHolder {
        public static final LazyStaticSingleton singleton = new LazyStaticSingleton();
    }

    public void methodA() {
    }

    public void methodB() {
    }

    public static void main(String[] args) {
        LazyStaticSingleton.getInstance().methodA();
        LazyStaticSingleton.getInstance().methodB();
    }
}
