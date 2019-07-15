package classes;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String weather;

    private WeatherProvider()
    {
        weatherProvider = this;
    }

    public static WeatherProvider getProvider()
    {
        new WeatherProvider();
        return(weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        Random random = new Random();
        String[] weatherOptions = {"SNOW", "SUN", "FOG", "RAIN"};
        int lat = coordinates.getLatitude();
        int lon = coordinates.getLongitude();
        int height = coordinates.getHeight();
        int index = (lat + lon + height + (random.nextInt(50) * 3)) % 4;
        weather = weatherOptions[index];
        return(weather);
    }
}
