package gbjc3.les02.oldChat;

import java.util.ArrayList;
import java.util.List;

class AuthService {
    List<Client> clients = new ArrayList();

    AuthService() {
        clients.add(new Client("Pavel", "pavel1", "12"));
        clients.add(new Client("Oleg", "oleg1", "12"));
        clients.add(new Client("Nick", "nick1", "12"));
    }

    synchronized Client auth(String login, String password) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.login.equals(login) && client.password.equals(password)) {
                return client;
            }
        }
        return null;
    }
}
