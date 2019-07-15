package classes;

import java.io.*;

public class Simulator {

    public static void main(String[] arg)
    {
        TextWriter log = TextWriter.getWriter();
        if (arg.length <= 0)
        {
            System.out.println("Invalid use: [java ~Simulation <scenario>]");
            System.exit(-1);
        }
        try
        {
            BufferedReader reader = null;
            File file = new File(arg[0]);
            reader = new BufferedReader(new FileReader(file));
            AircraftFactory factory = new AircraftFactory();
            WeatherTower tower = new WeatherTower();
            String line;
            String[] words;
            int counting = 0;

            line = reader.readLine();
            if (line.isEmpty() == true)
                System.exit(-1);
            try
            {
                counting = Integer.parseInt(line.trim());
                if (counting < 0)
                {
                    System.out.println("Invalid argument negative number");
                    System.exit(-1);
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println(e);
                System.exit(-1);
            }
            while ((line = reader.readLine()) != null)
            {
                words = line.split(" +|\t+");
                if (words.length != 5)
                {
                    System.out.println("invalid Number of Arguments: " + line);
                    System.exit(-1);
                }
                int lon = 0;
                int lat = 0;
                int height = 0;
                try
                {
                    lon = Integer.parseInt(words[2]);
                    lat = Integer.parseInt(words[3]);
                    height = Integer.parseInt(words[4]);
                }
                catch(NumberFormatException e)
                {
                    System.out.println(e);
                    System.exit(-1);
                }
                tower.registering(factory.newAircraft(words[0], words[1], lon, lat, height ) ) ;
            }
            while (counting > 0)
            {
                tower.changeWeather();
                counting--;
            }
            log.close();
            reader.close();
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        /*catch(MyException e)
        {
            System.out.println(e);
            System.exit(-1);
        }*/
    }
}
