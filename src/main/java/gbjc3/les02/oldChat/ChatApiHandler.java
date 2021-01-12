package gbjc3.les02.oldChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Через этот класс будет организована работа с сервером (перенес из класса Chat, который удалил)
public class ChatApiHandler {
    interface CallBack {
        void onAuth (boolean isSuccess, String serverError);
        void onNewMessage(String message);
    }

    ExecutorService executor = Executors.newSingleThreadExecutor();
    CallBack callBack;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    ChatApiHandler (CallBack callBack) {
        this.callBack = callBack;
        try {
            Socket socket = new Socket("localhost", 8081);
            dataInputStream = new DataInputStream(socket.getInputStream());
            //System.out.println("dataInputStream.readUTF(): " + dataInputStream.readUTF());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String newMessage = dataInputStream.readUTF();
                        System.out.println("123 - new message: " + newMessage +
                                " Начинается ли с /auth? - " + newMessage.startsWith("/auth"));
//                        System.out.println("/auth = " + newMessage.startsWith("//auth"));
//                        if (newMessage.equals("/auth")) {
                        if (newMessage.startsWith("/auth")) {
                            System.out.println(newMessage);
                            String authOk = "/auth ok";
                            System.out.println(authOk);
                            System.out.println("234, newMessage: " + newMessage +
                                    "; newMessage.equals(authOk) = " + newMessage.equals(authOk) +
                                    "; authOk == newMessage.intern(): " + (authOk == newMessage.intern()));
                            if (authOk.equalsIgnoreCase(newMessage)) {
                                System.out.println("response success");
                                System.out.println("777 - newMessage " + newMessage);
                                callBack.onAuth(true, null);
                            } else {
                                callBack.onAuth(false, newMessage);
                                System.out.println("888 - newMessage " + newMessage);
                            }
                        } else if (newMessage.startsWith("/nm") && newMessage.length() > 5)  {
                            callBack.onAuth(false, newMessage.substring(4));
                            callBack.onNewMessage(newMessage);
                            System.out.println("999");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized void auth(String login, String password) {
        // /auth login password
        new Thread(() -> {
            try {
                String command = "/auth " + login + " " + password;
                System.out.println("Авторизация: " + command);

                //проверка (после удалить)
//                String[] messageData = command.split("\\s");
//                System.out.println(messageData.length); // 3 слова в комане
//                System.out.println(messageData[0].equals("/AUTH")); // первое слово "/AUTH"

                dataOutputStream.writeUTF(command);
                String response = dataInputStream.readUTF();
            } catch (IOException e) {
                System.out.println("response exception");
                callBack.onAuth(false, null);
            }
        }).start();
    }

    synchronized public void sendMessage(String text) {
        //executor.submit(() -> {
        new Thread(() -> {
            try {
                dataOutputStream.writeUTF(text);
            } catch (IOException e) {
            }
        //});
        }).start();
    }
}
