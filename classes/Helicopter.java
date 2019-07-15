package classes;

public class Helicopter extends Aircraft implements Flyable{
    WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        String weather = this.weatherTower.getWeather(this.coordinates);
        String stored_string = "Helicopter#" + this.name + "(" + this.id + ")";
        if (weather.equals("RAIN"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": Its raining");
            if (height <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon + 5, lat, height);
        }
        else if (weather.equals("FOG"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": I cant see clearly");
            if (height <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon + 1, lat, height);
        }
        else if (weather.equals("SUN"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": This is hot");
            if ((height += 2) >= 100)
            {
                height = 100;
                this.coordinates = new Coordinates(lon + 10, lat, height);
            }
            else if (height <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon + 10, lat, height);
        }
        else if (weather.equals("SNOW"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": My rotor is going to freeze");
            if ((height -= 12) <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing");
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
