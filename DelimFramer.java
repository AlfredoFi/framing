import java.io.*;

public class DelimFramer implements Framer{   //clase DelimFramer hereda de Framer
  private InputStream in;
  private static final char DELIMITER = '\n';  //Declaración de parametros

  public DelimFramer(InputStream in){
    this.in = in;     //Declaración del constructor para DelimFramer
  }

  public void frameMsg(byte[] message, OutputStream out) throws IOException{  // Framer
    for(byte b : message){   //Ciclo para crear la seuencia del delimitador
      if(b == DELIMITER)
        throw new IOException("Delimiter is part of message");
    } 
    //impresión de resultados
    out.write(message);
    out.write(DELIMITER); 
    out.flush();          
  }

  public byte[] nextMsg() throws IOException{
    ByteArrayOutputStream message = new ByteArrayOutputStream();  //Creación de objeto message tipo ByteArray
    int nextByte; 
    while((nextByte = this.in.read()) != DELIMITER){  // ciclo para revisón de cada byte
      if(nextByte == -1){
        if(message.size() == 0) {
          return null;
        }else{
          throw new EOFException("Delimiter is not part of message"); // Excepción indica que no es parte del frame.
        }
      }
      message.write(nextByte);
    }
    return message.toByteArray();  // resultado del mensaje
  }
}
