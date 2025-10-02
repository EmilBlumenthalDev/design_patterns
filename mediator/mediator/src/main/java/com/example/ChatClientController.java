package com.example;
import javafx.scene.control.*;

public class ChatClientController implements ChatClient {
    private String name;
    private ChatMediatorImpl mediator;
    private TextArea chatArea;
    private ComboBox<String> recipientBox;
    private TextField inputField;

    public ChatClientController(
        String name, 
        ChatMediatorImpl mediator,
        TextArea chatArea, 
        ComboBox<String> recipientBox,
        TextField inputField
    ) {
        this.name = name;
        this.mediator = mediator;
        this.chatArea = chatArea;
        this.recipientBox = recipientBox;
        this.inputField = inputField;

        mediator.registerClient(this);
        refreshRecipients();
        
        recipientBox.setOnAction(e -> chatArea.clear());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void receiveMessage(String message) {
        chatArea.appendText(message + "\n");
    }

    public void sendMessage() {
        String recipient = recipientBox.getValue();
        String msg = inputField.getText();
        if (recipient != null && !msg.isEmpty()) {
            mediator.sendMessage(msg, name, recipient);
            inputField.clear();
        }
    }

    public void refreshRecipients() {
        recipientBox.getItems().clear();
        mediator.getClientNames().stream()
            .filter(clientName -> !clientName.equals(this.name))
            .forEach(recipientBox.getItems()::add);
    }
}
