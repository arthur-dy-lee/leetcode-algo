package arthur.dy.lee.pattern.behavioral.observer;

import java.beans.PropertyChangeListener;

public class Main {

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        PropertyChangeListener listener1 = new NewsChannel();
        agency.addListener(listener1);

        agency.updateNews("a");
        agency.updateNews("b");

    }
}
