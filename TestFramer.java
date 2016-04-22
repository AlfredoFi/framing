import java.io.*;

class TestFramer{

  private final static int mask = 0xFF;     // Mascara a utilizar
  public static void printByteArray(byte[] val){ // Arreglo de bytes
    StringBuilder str = new StringBuilder();     
    for(byte b : val){        //Ciclo para colocar información en cada byte
      str.append(b & mask).append(" ");
    }
    System.out.println(str.toString());  //imprime valor
  }

  //función Main para prueba de Framing
  public static void main(String[] args) throws FileNotFoundException, IOException{
  //Creación de objetos in e in1
    InputStream in1 = new FileInputStream("./test.txt");
    InputStream in = new FileInputStream("./test.txt");
    
    Framer delimiter_framer = new DelimFramer(in1);
    ByteArrayOutputStream delimiter_out = new ByteArrayOutputStream();
    byte [] delimiter_in = new byte[5]; //Creación de arreglo de 0-5 bytes 
    in.read(delimiter_in); 
    delimiter_framer.frameMsg(delimiter_in, delimiter_out);
    in.read();
    delimiter_in = new byte[5]; 
    in.read(delimiter_in);
    delimiter_framer.frameMsg(delimiter_in, delimiter_out);
    in.read();
    delimiter_in = new byte[1]; 
    in.read(delimiter_in);
    delimiter_framer.frameMsg(delimiter_in, delimiter_out);
    printByteArray(delimiter_out.toByteArray()); 
    printByteArray(delimiter_framer.nextMsg()); 
    printByteArray(delimiter_framer.nextMsg()); 
    printByteArray(delimiter_framer.nextMsg()); 
  }
}
