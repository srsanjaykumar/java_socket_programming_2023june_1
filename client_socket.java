// import java.io.DataOutputStream;
// import java.io.IOException;
// import java.net.Socket;
// import java.net.UnknownHostException;
import java.io.*;
import java.net.*;
public class client_socket {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("127.0.0.1", 6666);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("Hello  Server");
        dos.flush();
        dos.close();
        s.close();
        
    }
    
}
