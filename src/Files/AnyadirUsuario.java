package Files;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class AnyadirUsuario extends ObjectOutputStream
{
   
    public AnyadirUsuario(OutputStream out) throws IOException
    {
        super(out);
    }

    protected AnyadirUsuario() throws IOException, SecurityException
    {
        super();
    }

    protected void writeStreamHeader() throws IOException
    {
    }

}
