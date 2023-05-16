package arthur.dy.lee.pattern.creational.singleton;

import arthur.dy.lee.pattern.creational.singleton.lazy.LazyDoubleCheckSingleton;

public class ForbiddenRefactorSingleton {

    private static volatile ForbiddenRefactorSingleton singleton = null;

    private static boolean flag = false;

    private ForbiddenRefactorSingleton() {
        synchronized (ForbiddenRefactorSingleton.class) {
            if (!flag) {
                flag = Boolean.TRUE;
            } else {
                throw new RuntimeException("单例模式正在被攻击");
            }
        }
    }

    public static ForbiddenRefactorSingleton getInstance() {
        if (singleton == null) {
            /**
             * 为了在多线程环境下，不影响程序的性能，不让线程每次调用getInstanceC()方法时都加锁，
             * 而只是在实例未被创建时再加锁，在加锁处理里面还需要判断一次实例是否已存在。
             */
            synchronized (LazyDoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new ForbiddenRefactorSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        ForbiddenRefactorSingleton singleton1 = ForbiddenRefactorSingleton.getInstance();
        ForbiddenRefactorSingleton singleton2 = ForbiddenRefactorSingleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
