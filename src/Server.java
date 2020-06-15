import java.net.*;
import java.io.*;

public class Server {
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    private DataInputStream connect = null;
    private DataOutputStream out = null;

    // constructor with port
    public Server(int port) {
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // read data from keyboard
            input = new DataInputStream(System.in);

            // takes input from the client socket
            connect = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            // to send data to the client
            out = new DataOutputStream(socket.getOutputStream());

            String message = "";
            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    message = connect.readUTF();
                    System.out.println(message);

                    line = input.readLine();
                    out.writeUTF(line);

                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            connect.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
} 