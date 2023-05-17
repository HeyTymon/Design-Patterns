package observer;

public class Information implements Observer {

    @Override
    public void updateForecast(Weather weatherForecast) {
        System.out.println(weatherForecast.getName() + ":" + "\n" +"Temperature: " +  weatherForecast.getTemperature() + "C" + "\n" + "Pressure: " +  weatherForecast.getPressure() + "Pa");
    }
}
