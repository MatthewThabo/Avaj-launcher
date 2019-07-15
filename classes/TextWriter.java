package classes;

import java.io.*;
public class TextWriter
{
    private static PrintWriter writer;
    public static TextWriter textWriter;

    private TextWriter()
    {
        try
        {
            File file = new File("simulation.txt");
            if (file.exists() == false)
                file.createNewFile();
            writer = new PrintWriter(file) ;
        }
        catch(IOException e)
        {
            System.out.println("TextWriter Error: " + e);
        }
    }

    public static TextWriter getWriter()
    {
        if (textWriter == null)
            textWriter = new TextWriter();
        return(textWriter);
    }

    public void write_to_a_file(String str)
    {
        writer.println(str);
    }

    public void close()
    {
        writer.close();
    }
}
