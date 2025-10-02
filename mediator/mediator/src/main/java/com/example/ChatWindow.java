package com.example;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatWindow {
    public static void create(String username, ChatMediatorImpl mediator) {
        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField inputField = new TextField();
        ComboBox<String> recipientBox = new ComboBox<>();

        Button sendButton = new Button("Send");

        ChatClientController controller = new ChatClientController(username, mediator, chatArea, recipientBox, inputField);
        sendButton.setOnAction(e -> controller.sendMessage());

        VBox layout = new VBox(10, chatArea, recipientBox, inputField, sendButton);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout, 400, 300));
        stage.show();
    }
}
