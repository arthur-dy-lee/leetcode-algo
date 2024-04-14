package arthur.dy.lee.pattern.behavioral.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NewsChannel implements PropertyChangeListener {

    private String news;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.news = (String) evt.getNewValue();
        System.out.println("news updated: " + news);
    }
}
