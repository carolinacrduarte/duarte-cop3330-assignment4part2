package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Carolina Duarte
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;


public class TaskController implements Initializable {

    public TaskController() throws FileNotFoundException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.datePicker = new DatePicker(LocalDate.now());
    }

    @FXML
    TextField nameTextField;

    @FXML
    DatePicker datePicker;

    @FXML
    TextArea descriptionTextArea;

    @FXML
    Button addTaskButton;

    @FXML
    Button removeTaskButton;

    @FXML
    Button removeAllTasksButton;

    @FXML
    Button markCompleteButton;

    @FXML
    Button saveExportButton;

    @FXML
    Button importButton;

    @FXML
    ListView<ToDoTask> taskList;

    static ObservableList<ToDoTask> ToDoTasks = FXCollections.observableArrayList(new ArrayList<>());

    FileOutputStream fileOut = new FileOutputStream("ToDoAppTasks.txt");

    @FXML
    public void addTaskEvent(Event e) {

        ToDoTasks.add(new ToDoTask(nameTextField.getText(), datePicker.getValue(), descriptionTextArea.getText()));
        taskList.setItems(ToDoTasks);

    }

    private ToDoTask selUser()
    {
        return taskList.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void removeTaskEvent(Event e) {
        ToDoTasks.remove(selUser());
        taskList.setItems(ToDoTasks);
    }

    @FXML
    public void removeAllTasksEvent(Event e){
        taskList.getItems().clear();
    }

    public void saveExport() throws IOException {

        OutputStreamWriter outputWriter = new OutputStreamWriter(fileOut);
        String data = String.valueOf(ToDoTasks).replaceAll(", ", "\n").replaceAll("\\[", "").replaceAll("\\[", "").replaceAll("\\]","");

        outputWriter.write(data);
        outputWriter.close();

        JOptionPane.showMessageDialog(null,
                "Your to-do list was saved successfully!",
                "Save/Export",
                JOptionPane.WARNING_MESSAGE);
    }

    @FXML
    public void saveExportEvent(Event e) throws IOException {
        saveExport();
    }

    public void importEvent() throws IOException {
        File file = new File("ToDoAppTasks.txt");
        Scanner inputFile = new Scanner(file);

    }

    @FXML public void importEvent(Event e) throws IOException {
        importEvent();
    }

}




