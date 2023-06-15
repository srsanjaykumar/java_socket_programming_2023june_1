import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class my_client {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket s = new Socket("127.0.0.1", 6161);
        // message send to the socket
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        // get a input form the socket
        DataInputStream dis = new DataInputStream(s.getInputStream());
        // get input from the client keyboard
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Send message to server");
        String str1 = " ", str2 = "";
        while (!str1.equalsIgnoreCase("stop")) {
            // message send from client side
            // read input from the client
            str1 = br.readLine();
            // send data from the server socket
            dos.writeUTF(str1);
            str2 = dis.readUTF();
            if (str1.equalsIgnoreCase("stop") || str2.equalsIgnoreCase("stop")) {
                dos.writeUTF(str1);
                System.out.println("Connection Closed , Thank You ..........");
                dos.close();
                s.close();
                System.exit(0);
            }

            
            // clear the old message
            dos.flush();
            // read input from the server
            
            System.out.println("Server Message : " + str2);
        }

    }
}
