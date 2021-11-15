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
import java.time.format.DateTimeFormatter;
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
        String data = String.valueOf(ToDoTasks).replaceAll(", ", "\n").replaceAll(" / ", "\n").replaceAll("\\[", "").replaceAll("\\[", "").replaceAll("\\]","");

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

        BufferedReader reader = new BufferedReader(new FileReader("ToDoAppTasks.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String task_name;
            task_name = line.substring(line.indexOf(": ") + 1);

            String temp_due_date;
            String task_description;

            temp_due_date = line.substring(line.indexOf(": ") + 1);
            task_description = line.substring(line.indexOf(": ") + 1);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate due_date = LocalDate.parse(temp_due_date, formatter);

            ToDoTasks.add(new ToDoTask(task_name, due_date, task_description));
            taskList.setItems(ToDoTasks);
        }
    }

    @FXML public void importEvent(Event e) throws IOException {
        importEvent();
    }

}
