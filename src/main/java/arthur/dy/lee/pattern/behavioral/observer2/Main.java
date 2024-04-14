package arthur.dy.lee.pattern.behavioral.observer2;

public class Main {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        TemperatureDisplay td1 = new TemperatureDisplay("td1");
        ws.addListener(td1);
        ws.updateWeather(1);
        ws.updateWeather(22);

        TemperatureDisplay td2= new TemperatureDisplay("td2");
        ws.addListener(td2);
        ws.updateWeather(300);
    }
}
