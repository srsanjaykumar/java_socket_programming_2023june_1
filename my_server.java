import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class my_server {
    public static void main(String[] args) throws IOException {
        // Create server socket
        ServerSocket soc = new ServerSocket(6161);
        // get connect form the client
        Socket s = soc.accept();
        // we get the input in to the socket
        DataInputStream dis = new DataInputStream(s.getInputStream());
        // send message to the clinet via socket
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        // get input from sever user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Waiting to get message form the client side");
        String str = "", str2 = "";
        while (!str.equalsIgnoreCase("stop")) {
            // it will get the input from the client side
            str = dis.readUTF();
            System.out.println("Client says : " + str);
            
            if (str.equalsIgnoreCase("stop")) {
                dos.writeUTF(str2);
                System.out.println("Connection Closed  , Done .......");
                dis.close();
                soc.close();
                s.close();
                System.exit(0);
            }
            // it will get input to server from server user
            str2 = br.readLine();

            // this set of code when server send to stop  bith side connection goes stop 

            // if (str2.equalsIgnoreCase("stop")) {
            //     dos.writeUTF(str2);
            //     System.out.println("Connection Closed  , Done .......");
            //     dis.close();
            //     soc.close();
            //     s.close();
            //     System.exit(0);
            // }


            // message send in to the client
            dos.writeUTF(str2);
            // flush the old message
            dos.flush();
        }

    }
}
