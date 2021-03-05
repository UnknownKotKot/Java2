import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient extends JFrame {

        private final static String IP_ADDRESS = "localhost";
        private final static int SERVER_PORT = 8181;

        private JTextField jInputMessageHere;
        private JTextField jInputNameHere;
        private JTextArea jChatField;

        private String userName = "";
        private String messageToPrint = "";
        private String messageToSend = "";
        private String serverMessage = null;

        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        private void connection() throws IOException {
            socket = new Socket(IP_ADDRESS, SERVER_PORT);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            new Thread(()->{
                while (true) {
                    try {
                        serverMessage = dis.readUTF();
                        if(serverMessage.equalsIgnoreCase("/q")){
                            break;
                        }
                        jChatField.append(serverMessage + "\n");
                        if(serverMessage!=null){
                            messageToPrint = messageToPrint.concat(serverMessage + "\n");
                            serverMessage = null;
                        }
                    } catch (IOException ignored) {
                    }
                }
                closeConnection(socket, dis, dos);
            }).start();
        }

        private void sendMessageToServer(){
            if(!jInputMessageHere.getText().trim().isEmpty()){
                try {
                    sendMsg();
                    dos.writeUTF(messageToSend);
                    dos.flush();
                } catch (IOException ignored) {
                }
            }
        }

        public ChatClient() {

            setBounds(640, 480, 640, 480);
            setTitle("Chat ver: 0.2");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jChatField = new JTextArea();
            jChatField.setEditable(false);
            jChatField.setLineWrap(true);

            JScrollPane jsp = new JScrollPane(jChatField);
            add(jsp, BorderLayout.CENTER);

            JLabel jlYourMessages = new JLabel("Ваши сообщения: ");
            add(jlYourMessages, BorderLayout.NORTH);

            JPanel bottomPanel = new JPanel(new BorderLayout());
            add(bottomPanel, BorderLayout.SOUTH);

            JButton jbSendMessage = new JButton("Отправить");
            bottomPanel.add(jbSendMessage, BorderLayout.EAST);

            jInputMessageHere = new JTextField("Введите ваше сообщение: ");
            bottomPanel.add(jInputMessageHere, BorderLayout.CENTER);

            jInputNameHere = new JTextField("Введите ваше имя: ");
            bottomPanel.add(jInputNameHere, BorderLayout.WEST);

            jbSendMessage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!jInputMessageHere.getText().trim().isEmpty() && !jInputNameHere.getText().trim().isEmpty()) {
                        userName = jInputNameHere.getText();
                        sendMessageToServer();
                        jInputMessageHere.grabFocus();
                    }
                }
            });

            jInputMessageHere.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    jInputMessageHere.setText("");
                }
            });

            jInputNameHere.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    jInputNameHere.setText("");
                }
            });

            jInputMessageHere.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!jInputMessageHere.getText().trim().isEmpty() && !jInputNameHere.getText().trim().isEmpty()) {
                        userName = jInputNameHere.getText();
                        sendMessageToServer();
                        jInputMessageHere.setText("");
                    }
                }
            });

            addWindowListener((new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    try {
                        dos.writeUTF("/q");
                        closeConnection(socket, dis, dos);
                    } catch (IOException ignored) {
                    }
                }
            }));
            setVisible(true);
        }

        public void sendMsg() {
            if(serverMessage!=null){
                messageToPrint = messageToPrint.concat(serverMessage);
                serverMessage = null;
            }
            messageToPrint = messageToPrint.concat(jInputNameHere.getText() + "" + ":" + jInputMessageHere.getText() + "\n");
            jChatField.setText(messageToPrint);
            messageToSend = jInputNameHere.getText() + "" + ":" + jInputMessageHere.getText() + "\n";
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
                socket.close();
            } catch (IOException ignored) {
            }
        }

        public static void main(String[] args) {
            ChatClient cc = new ChatClient();
            try {
                cc.connection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

