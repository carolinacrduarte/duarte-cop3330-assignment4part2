package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Carolina Duarte
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AddList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Your to-do lists!");
        stage.setScene(scene);
        stage.show();
    }

    /*@Override
    public void *function name* throws Exception {
        Function called TaskSerializer to serialize data from LocalTask class.
    }*/

    /*@Override
    public void *function name* throws Exception {
        Function called ListSerializer to serialize data from LocalList class.
    }*/

    public static void main(String[] args) {
        launch();
    }
}