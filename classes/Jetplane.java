package classes;

public class Jetplane extends Aircraft implements Flyable{
    WeatherTower weatherTower;

    Jetplane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        String weather = this.weatherTower.getWeather(this.coordinates);
        String stored_string = "JetPlane#" + this.name + "(" + this.id + ")";
        if (weather.equals("RAIN"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": It's raining. Better watch out for lightings.");
            if (height <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing ");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon, lat + 5, height);
        }
        else if (weather.equals("FOG"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": OMG! winter is coming.");
            if (height <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing ");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon, lat + 1, height);
        }
        else if (weather.equals("SUN"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": It's so hot");
            if ((height += 2) >= 100)
            {
                height = 100;
                this.coordinates = new Coordinates(lon, lat + 10, height);
            }
            else if (height <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing ");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon, lat + 10, height);
        }
        else if (weather.equals("SNOW"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": It's snowing.");
            if ((height -= 7) <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing ");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon, lat, height);
        }
    }

    public void registerTower(WeatherTower weatherTower)

    {
        this.weatherTower = weatherTower;
    }
}
