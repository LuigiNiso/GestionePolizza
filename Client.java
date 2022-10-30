import java.io.*;
import java.net.*;

/**
 * Server
 */
public class Client {
    private static Socket socket;
    private final int PORT = 7878;

    // Streams for strings
    private BufferedReader inString;
    private BufferedWriter outString;

    // Streams for objects
    private ObjectInputStream inObj;
    private ObjectOutputStream outObj;

    public Client() {
    }

    public void connectToServer(String ip) {
        try {
            System.out.println("Connecting to the server...");
            socket = new Socket(ip, PORT);

            // Create streams
            inString = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outString = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            outObj = new ObjectOutputStream(socket.getOutputStream());
            inObj = new ObjectInputStream(socket.getInputStream());

            System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public void sendString(String data) {
        try {
            outString.write(data);
            outString.newLine();
            outString.flush();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public String readString() {
        try {
            return inString.readLine();
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
            return null;
        }
    }

    public void sendObj(Object data) {
        try {
            outObj.writeObject(data);
            outObj.flush();
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public Object readObj() {
        try {
            return inObj.readObject();
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try {
            // Close streams
            inString.close();
            outString.close();
            inObj.close();
            outObj.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}