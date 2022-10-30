import java.io.*;
import java.net.*;

/**
 * Server
 */
public class Server {

    private ServerSocket serverSocket;
    private final int PORT = 7878;

    public Server() {
    }

    private void startServer() {
        try {
            System.out.println("Starting server...");
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started!");
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public void connectClients() {
        try {
            Socket client;

            // streams for strings
            BufferedReader inString;
            BufferedWriter outString;

            // streams for objects
            ObjectInputStream inObj;
            ObjectOutputStream outObj;

            DBManager dbManager;

            while (true) {
                System.out.println("Waiting for connection...");
                client = serverSocket.accept();
                System.out.println("Client connected!");

                // Create streams
                inString = new BufferedReader(new InputStreamReader(client.getInputStream()));
                outString = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                inObj = new ObjectInputStream(client.getInputStream());
                outObj = new ObjectOutputStream(client.getOutputStream());

                String operation = inString.readLine();
                System.out.println(operation);

                System.out.println("Create db manager");
                dbManager = new DBManager();

                switch (operation) {
                    case "login": {
                        System.out.println("Login...");
                        dbManager.connectToDB();
                        String email = inString.readLine();
                        String password = inString.readLine();

                        outString.write(dbManager.login(email, password));
                        outString.newLine();
                        outString.flush();
                        break;
                    }

                    case "register": {
                        System.out.println("Register...");
                        dbManager.connectToDB();

                        String email = inString.readLine();
                        String password1 = inString.readLine();
                        String password2 = inString.readLine();
                        int admin = 0;

                        BufferedReader fIn = new BufferedReader(new FileReader(new File("admins.txt")));

                        String line = fIn.readLine();

                        while (line != null) {
                            if (line.compareTo(email) == 0) {
                                admin = 1;
                            }
                            line = fIn.readLine();
                        }

                        if (password1.compareTo(password2) == 0) {
                            if (dbManager.register(email, password1, admin)) {
                                outString.write("accedi");
                                outString.newLine();
                                outString.flush();
                            } else {
                                outString.write("Email già registrata!");
                                outString.newLine();
                                outString.flush();
                            }
                        } else {
                            outString.write("Le password non corrispondono!");
                            outString.newLine();
                            outString.flush();
                        }
                        fIn.close();
                        break;
                    }

                    case "addVehicle": {
                        dbManager.connectToDB();

                        String targa = inString.readLine();
                        String modello = inString.readLine();
                        int cilindrata = (Integer) inObj.readObject();
                        int scadenza = (Integer) inObj.readObject();

                        if (dbManager.addVehicle(targa, modello, cilindrata, scadenza)) {
                            outString.write("Veicolo aggiunto!");
                            outString.newLine();
                            outString.flush();
                        } else {
                            outString.write("Ops, veicolo non aggiunto!");
                            outString.newLine();
                            outString.flush();
                        }
                        break;
                    }

                    case "search": {
                        dbManager.connectToDB();

                        String targa = inString.readLine();

                        outString.write(dbManager.getScadenza(targa));
                        outString.newLine();
                        outString.flush();
                        break;
                    }

                    default:
                        break;
                }

                // Close streams
                inString.close();
                outString.close();
                inObj.close();
                outObj.close();
                client.close();
            }
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();

        // start to listen for clients
        server.connectClients();
    }
}