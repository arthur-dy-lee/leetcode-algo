package arthur.dy.lee.pattern.behavioral.observer2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WeatherStation {

    private int                   temperature;
    private PropertyChangeSupport support;

    public WeatherStation() {
        support = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void remove(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void updateWeather(int newTemperature) {
        support.firePropertyChange("temperature", this.temperature, newTemperature);
        this.temperature = newTemperature;
    }

}
