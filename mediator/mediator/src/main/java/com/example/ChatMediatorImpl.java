
package com.example;
import java.util.*;

public class ChatMediatorImpl implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getName(), client);
        for (ChatClient existingClient : clients.values()) {
            if (existingClient instanceof ChatClientController) {
                ((ChatClientController) existingClient).refreshRecipients();
            }
        }
    }

    @Override
    public void sendMessage(String message, String from, String to) {
        ChatClient recipient = clients.get(to);
        ChatClient sender = clients.get(from);
        
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
