
package com.example;
import java.util.*;

public class ChatMediator implements ChatMediatorInterface {
    private Map<String, ChatClientInterface> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientInterface client) {
        clients.put(client.getName(), client);
        for (ChatClientInterface existingClient : clients.values()) {
            if (existingClient instanceof ChatClientController) {
                ((ChatClientController) existingClient).refreshRecipients();
            }
        }
    }

    @Override
    public void sendMessage(String message, String from, String to) {
        ChatClientInterface recipient = clients.get(to);
        ChatClientInterface sender = clients.get(from);
        
        if (recipient != null) {
            recipient.receiveMessage(from + ": " + message);
            if (sender != null) {
                sender.receiveMessage(from + ": " + message);
            }
        } else {
            if (sender != null) {
                sender.receiveMessage("[System] User " + to + " not found.");
            }
        }
    }

    public Set<String> getClientNames() {
        return clients.keySet();
    }
}
