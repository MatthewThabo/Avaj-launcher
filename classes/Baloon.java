package classes;

public class Baloon extends Aircraft implements Flyable{


    private WeatherTower weatherTower;

    Baloon (String name, Coordinates coordinates)
    {
        super(name, coordinates);

    }
    public void updateConditions()
    {

        int height = this.coordinates.getHeight();
        int lat = this.coordinates.getLatitude();
        int lon = this.coordinates.getLongitude();
        String weather = this.weatherTower.getWeather(this.coordinates);
        String stored_string = "Baloon#" + this.name + "(" + this.id + ")";
        if (weather.equals("RAIN"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": Damn you rain! You messed up my baloon");
            if ((height -= 5) <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new  Coordinates(lat, lon, height);
        }
        else if (weather.equals("FOG"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": I cant see clearly");
            if ((height -= 3) <= 0)
            {
                height = 0;
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon, lat, height);
        }
        else if (weather.equals("SUN"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": Lets enjoy the good weather and take some pics");
            if ((height += 4) >= 100)
            {
                height = 100;
                this.coordinates = new Coordinates(lon + 2, lat, height);
            }
            else if (height <= 0)
            {
                TextWriter.textWriter.write_to_a_file(stored_string + ": Landing");
                this.weatherTower.unregister(this);
            }
            else
                this.coordinates = new Coordinates(lon + 2, lat, height);
        }
        else if (weather.equals("SNOW"))
        {
            TextWriter.textWriter.write_to_a_file(stored_string + ": Its snowing. we're gonna crash.");
            if ((height -= 15) <= 0)
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
