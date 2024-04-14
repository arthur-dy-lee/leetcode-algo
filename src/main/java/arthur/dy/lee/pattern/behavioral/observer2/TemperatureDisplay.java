package arthur.dy.lee.pattern.behavioral.observer2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureDisplay implements PropertyChangeListener {

    private int temperature;

    public String tdName;

    public TemperatureDisplay(String tdName) {
        this.tdName = tdName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(this.tdName + " get new temperature:" + evt.getNewValue());
        temperature = (Integer) evt.getNewValue();
    }
}
