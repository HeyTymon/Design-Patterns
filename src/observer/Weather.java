package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weather implements Observable {

    long pressure;
    int temperature;

    List<Observer> observersList = new ArrayList<>();

    public Weather(long pressure, int temperature) {
        this.pressure = pressure;
        this.temperature = temperature;
    }

    public void updateWeather()
    {
        this.pressure = this. pressure + (new Random().nextLong(10));
        this.temperature = this. temperature + (new Random().nextInt(3));
        notifyObservers();
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
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
        for(Observer o: observersList)
        {
            o.updateForecast(this);
        }
    }
}
