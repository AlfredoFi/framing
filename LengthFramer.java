import java.io.*;

public class LengthFramer implements Framer{ // clase LengthFramer hereda de Framer
  public static final int MAXLENGHT = 65535; // Tamaño maximo de la trama
  public static final int BYTEMASK  = 0xff;  // Mascara a utilizar

  private InputStream in;  
//Declaración del constructor
  public LengthFramer(InputStream in){
    this.in = in;      
  }

  public void frameMsg(byte[] message, OutputStream out) throws IOException{
  }

  public byte[] nextMsg() throws IOException{
    return null;
  }
}

