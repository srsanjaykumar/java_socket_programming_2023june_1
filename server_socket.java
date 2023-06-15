import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server_socket {

    public static void main(String[] args) throws IOException,EOFException {
        ServerSocket soc = new ServerSocket(6666);
        Socket s = soc.accept();// established connection 
        DataInputStream dis = new DataInputStream(s.getInputStream()); //s.getInputputStream()  get the input from scoket
        String str =(String)dis.readUTF();
        System.out.println(" client Message : "+str);
        soc.close();
  
    }
}
