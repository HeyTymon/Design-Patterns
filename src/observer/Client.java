package observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        Weather weather1 = new Weather(1000,30, "Weather 1");
        Weather weather2 = new Weather(1000,30, "Weather 2");

        Information information1 = new Information();
        Information information2 = new Information();

        weather1.registerObserver(information1);
        weather2.registerObserver(information2);
        //weather2.registerObserver(new Information());

        WeatherThread weatherThread1 = new WeatherThread(weather1);
        WeatherThread weatherThread2 = new WeatherThread(weather2);

        weatherThread1.start();
        weatherThread1.join();

        weatherThread2.start();
        weatherThread2.join(2);

    }
}
