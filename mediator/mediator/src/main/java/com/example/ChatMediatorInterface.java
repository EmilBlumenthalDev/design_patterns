package com.example;

public interface ChatMediatorInterface {
    void registerClient(ChatClientInterface client);
    void sendMessage(String message, String from, String to);
}