package arthur.dy.lee.pattern.creational.singleton.hungry;

import arthur.dy.lee.pattern.creational.singleton.hungry.bean.DBClient;

/**
 * 思考一下，这个枚举应该是不对的。
 * DBClient的创建并不能保证调用者一定是从SingletonEnum2获取，而不是直接new或反射创建。
 */
enum SingletonEnumError {
    INSTANCE;

    private final DBClient dbClient;

    SingletonEnumError() {
        dbClient = new DBClient();
    }

    public DBClient getDBClient() {
        return dbClient;
    }

    public static void main(String[] args) {
        DBClient dbClient1 = SingletonEnumError.INSTANCE.getDBClient();
        DBClient dbClient2 = SingletonEnumError.INSTANCE.getDBClient();

        System.out.println(dbClient2 == dbClient1);
    }
}
