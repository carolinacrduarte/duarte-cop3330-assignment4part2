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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


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
        outputWriter.write(String.valueOf(ToDoTasks));
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

}




