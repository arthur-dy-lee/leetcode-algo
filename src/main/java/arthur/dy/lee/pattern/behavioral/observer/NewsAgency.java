package arthur.dy.lee.pattern.behavioral.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 定义Observable对象：
 * Java标准库中的java.util.Observable类已经被标记为过时，因此我们将使用PropertyChangeSupport来实现Observable的功能。
 *
 * 定义Observer对象：
 * Observer将通过实现PropertyChangeListener接口来定义。
 *
 */
public class NewsAgency {

    private PropertyChangeSupport support;
    private String news;
    public NewsAgency() {
        support = new PropertyChangeSupport(this);
    }
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }
    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    public void updateNews(String value) {
        support.firePropertyChange("news", this.news, value);
        this.news = value;
    }


}
