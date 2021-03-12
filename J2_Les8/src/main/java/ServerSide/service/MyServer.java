package ServerSide.service;

import ServerSide.interfaces.AuthenticationService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    private final int PORT =8081;
    private Socket socket;
    //обработчик клиентов сервера
    private List<ClientHandler> clientsList;
    private AuthenticationService authService;

    public AuthenticationService getAuthService(){//геттер аутент сервиса
        return this.authService;
    }

    public static void main(String[] args) {
        new MyServer();
    }

    public MyServer(){

        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            this.authService = new AuthenticationServiceImpl();
            authService.start();
            clientsList = new ArrayList<>();
            while(true){
                socket = serverSocket.accept();//создание сокета
                new ClientHandler(this, socket);//при передачи this приватные поля не передаются
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if (authService!=null){
                authService.stop();
            }
        }
    }

    public synchronized void sendMessageToClients(String message){//synchronized тк будет работать в потоках
        for (ClientHandler c : clientsList){
            c.sendMessage(message);
        }
    }

    public synchronized void sendPrivateMessage(String message, String nameRecipient, String nameSender) {
       if(clientsList.stream()
                .noneMatch(a -> a.getName().equals(nameRecipient))){
           clientsList.stream()
                   .filter(a->a.getName().equals(nameSender))
                   .forEach(a->a.sendMessage("No such active users."));
        }else{
           clientsList.stream()
                   .filter(a->a.getName().equals(nameRecipient))
                   .forEach(a->a.sendMessage("Message from [" + nameSender +"] :" + message));
       }
    }

    public synchronized void  sendOnlineClientList(ClientHandler c) {
        c.sendMessage("Users online: " + clientsList.toString());
    }

    public synchronized void subscribe(ClientHandler c){
        clientsList.add(c);
    }
    public synchronized void unSubscribe(ClientHandler c){
        clientsList.remove(c);
    }

    public boolean isNickBusy(String nick){
        return clientsList.stream()
                .anyMatch(a->a.getName().equals(nick));
    }


    private void closeConnection(Socket s, DataInputStream dis, DataOutputStream dos){
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
