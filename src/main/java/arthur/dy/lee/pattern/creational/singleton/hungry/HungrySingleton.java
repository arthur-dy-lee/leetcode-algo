package arthur.dy.lee.pattern.creational.singleton.hungry;

public class HungrySingleton {

    private static volatile HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return singleton;
    }

}
