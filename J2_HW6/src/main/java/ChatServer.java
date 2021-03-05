import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {

        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8181)) {

            System.out.println("Server started");
            socket = serverSocket.accept();
            System.out.println("client ready");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            new Thread(()->{
                while (true) {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        String str = br.readLine();
                        if(str.equalsIgnoreCase("/q")){
                            break;
                        }
                        if(!str.trim().isEmpty()){
                            dos.writeUTF("Server message: " + str);
                            dos.flush();
                        }
                    } catch (IOException ignored) {}
                }
            }).start();

            while(true){
                String clientMessage = dis.readUTF();
                System.out.println(clientMessage);
                if(clientMessage.equalsIgnoreCase("/q")) {
                    dos.writeUTF("/q");
                    closeConnection(socket, dis, dos);
                    break;
                }
                dos.flush();
            }
            dis.close();
        } catch (IOException ignored){
        }
    }

    private static void closeConnection(Socket s, DataInputStream dis, DataOutputStream dos){
        try {
            dos.flush();
        } catch (IOException ignored) {
        }
        try {
            dis.close();
        } catch (IOException ignored) {
        }
        try {
            dos.close();
        } catch (IOException ignored) {
        }
        try {
            s.close();
        } catch (IOException ignored) {
        }
    }
}

