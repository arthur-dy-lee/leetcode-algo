package arthur.dy.lee.pattern.creational.singleton.hungry;

/**
 * 创建对象时有可能会导致单例对象的不唯一，如何解决这些问题呢？
 * (1) 为了防止客户端使用克隆方法来创建对象，单例类不能实现Cloneable接口，即不能支持clone()方法。
 * (2) 由于反射可以获取到类的构造函数，包括私有构造函数，因此反射可以生成新的对象。【如何解决：采用枚举实现】
 * 采用一些传统的实现方法都不能避免客户端通过反射来创建新对象，此时，我们可以通过枚举单例对象的方式来解决该问题。
 * (3) 在原型模式中，我们可以通过反序列化实现深克隆，反序列化也会生成新的对象。具体来说就是每调用一次readObject()方法，都将会返回一个新建的实例对象，这个新建的实例对象不同于类在初始化时创建的实例对象。
 * 那么，如何防止反序列化创建对象呢？解决方法一是类不能实现Serializable接口，即不允许该类支持序列化，这将导致类的应用受限制（有时候我们还是需要对一个对象进行持久化处理）；解决方法二就是本文将要详细介绍的枚举实现。
 * <p>
 * Google 首席 Java 架构师、《Effective Java》一书作者、Java集合框架的开创者Joshua Bloch在Effective Java一书中提到：
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 * <p>
 * Java虚拟机会保证枚举对象的唯一性，因此每一个枚举类型和定义的枚举变量在JVM中都是唯一的。
 * <p>
 * 枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式!
 *
 *
 * 1. 编码约束
 * 在常规类中，有些事情可以实现，但在枚举类中被禁止。例如，访问构造函数中的静态字段。由于他在一个特殊的层次上工作，程序员需要更加小心。
 *
 * 2. 可串行性
 * 对于单例来说，有状态是很常见的。一般来说，这些单例不应该是可序列化的。从一个VM到另一个VM之间传输一个有状态的单例是没有意义的;
 * 单例是指“unique within a VM” not “unique in the universe”。
 * 如果序列化对于有状态的单例确实有意义，那么单例应该明确而准确地指定在另一个VM中反序列化一个可能已经存在相同类型的单例的单例意味着什么。
 *
 * 我们在枚举上节省了一些代码行，但是代价太高了，我们必须承担所有的包袱和枚举的限制，我们无意中继承了枚举的“特性”，这些特性会产生意想不到的后果。一个缺点被证明是唯一的好处——自动序列化。
 */
enum SingletonEnum {
    INSTANCE;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }

}
