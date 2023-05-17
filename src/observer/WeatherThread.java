package observer;

public class WeatherThread extends Thread
{
    Weather currentWeather;

    public WeatherThread(Weather currentWeather) {
        this.currentWeather = currentWeather;
    }

    @Override
    public void run() {

        for(int i = 0; i < 10; i++)
        {
            System.out.println("In " + Thread.currentThread().getName() + " the weather is: ");
            currentWeather.updateWeather();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
