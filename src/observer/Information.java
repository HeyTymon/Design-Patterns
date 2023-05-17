package observer;

public class Information implements Observer {

    @Override
    public void updateForecast(Weather weatherForecast) {
        System.out.println("Temperature: " +  weatherForecast.getTemperature() + "C");
        System.out.println("Pressure: " +  weatherForecast.getPressure() + "Pa");
        System.out.println();
    }
}
