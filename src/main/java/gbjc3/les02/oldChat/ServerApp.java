package gbjc3.les02.oldChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Server {

    List<ClientHandler> clients = new ArrayList<>();
//    List<Message> messages = new ArrayList<>();
    Map<String, List<Message>> chats = new HashMap<>();

    Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8083);
            AuthService authService = new AuthService();
            // Обработчик клиентов
            while (true) {
                System.out.println("DDD");
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    System.out.println("ZZZ");
                    new ClientHandler(authService, this, socket);
                }).start();
            }
        } catch (IOException e) {
            System.out.println("Сервер прекратил работу с ошибкой");
            e.printStackTrace();
        }
    }

//    synchronized void onNewMessage(Client client, String message) {
    synchronized void sendBroadCastMessage(Client sender, String textMessage) { // переименовали onNewMessage
        for (int i = 0; i < clients.size(); i++) {
            String recipientLogin = clients.get(i).client.login;
            sendMessageTo(sender, recipientLogin, textMessage);
        }
    }

    synchronized void sendMessageTo(Client sender, String recipientLogin, String messageText) {
        // Получаем логин получателя для поиска
        String sendLogin = sender.login;
        // Генерируем ключ чата
        String key;
        if (sender.login.compareTo(recipientLogin) > 0) {   // проверить compareTo
            key = sendLogin + recipientLogin;
        } else {
            key = recipientLogin + sendLogin;
        }
        // Проверяем есть ли такой чат и, если нет, создаем новый
        if (!chats.containsKey(key)) {
            // Создаем список сообщений для чата
            chats.put(key, new ArrayList<>());
        }
        // Сохраняем сообщение в чат
        chats.get(key).add(new Message(sender, messageText));
        // Ищем получателей среди клиентов
        ClientHandler recipient = null;
        for (int i = 0; i < clients.size(); i++) {
            ClientHandler client = clients.get(i);
            if (client.client.login.equals(recipientLogin)) {
                recipient = client;
            }
        }
        // Если получатель онлайн, то отправляем ему сообщение
        if (recipient != null) {
        //if (recipient != null && recipient.equals(sender.login)) {
            recipient.sendMessage(sender, messageText);
            System.out.println("Отправлено сообщение для " + recipientLogin);
        } else {
            System.out.println("Получатель не найден! " + recipientLogin);
        }
    }

    synchronized void onNewClient(ClientHandler clientHandler) {
        clients.add(clientHandler);
        sendBroadCastMessage(clientHandler.client, "Вошел в чат");
    }

    synchronized void onClientDisconnected(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        sendBroadCastMessage(clientHandler.client, "Покинул чат");
    }

    public static void main(String[] args) {
        new Server();
    }
}