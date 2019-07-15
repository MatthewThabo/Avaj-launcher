package classes;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        if (type.equals("Baloon"))
        {
            return(new Baloon(name, new Coordinates(longitude, latitude, height)));
        }
        else if (type.equals("Jetplane"))
        {
            return(new Jetplane(name, new Coordinates(longitude, latitude, height)));
        }
        else if (type.equals("Helicopter"))
        {
            return(new Helicopter(name, new Coordinates(longitude, latitude, height)));
        }
        else
        {
            System.out.println("Invalid Flyable type: " + type);
            System.exit(-1);
        }
        return(null);
    }
}
