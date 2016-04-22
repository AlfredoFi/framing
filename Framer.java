import java.io.IOException; // se importan las excepciones para cachar cualquier evento no deseado
import java.io.OutputStream;

public interface Framer{
  void frameMsg(byte[] message, OutputStream out) throws IOException; 
  byte[] nextMsg() throws IOException;  //arreglo byte de mensajes a partir de IOException
}
