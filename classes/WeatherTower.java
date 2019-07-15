package classes;

public class WeatherTower  extends Tower{
    private WeatherProvider weatherProvider;

    public WeatherTower()
    {
        this.weatherProvider = WeatherProvider.getProvider();
    }

    public String getWeather(Coordinates coordinates)
    {
        return(this.weatherProvider.getCurrentWeather(coordinates));
    }

    void changeWeather()
    {
        this.conditionsChanged();
    }

    public void registering(Flyable flyable)
    {
        this.register(flyable);
        flyable.registerTower(this);
    }
}
