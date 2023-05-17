package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weather implements Observable {

    String name;
    long pressure;
    int temperature;

    List<Observer> observersList = new ArrayList<>();

    public Weather(long pressure, int temperature, String name) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.name = name;
    }

    public void updateWeather() {
        this.pressure = this.pressure + (new Random().nextLong(10));
        this.temperature = this.temperature + (new Random().nextInt(3));
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public long getPressure() {
        return pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observersList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observersList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observersList) {
            o.updateForecast(this);
        }
    }
}
