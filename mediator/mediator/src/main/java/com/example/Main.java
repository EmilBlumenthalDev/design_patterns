package com.example;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ChatMediatorImpl mediator = new ChatMediatorImpl();

        ChatWindow.create("Pekka", mediator);
        ChatWindow.create("Jaska", mediator);
        ChatWindow.create("Lissu", mediator);
    }

    public static void main(String[] args) {
        launch(args);
    }
}