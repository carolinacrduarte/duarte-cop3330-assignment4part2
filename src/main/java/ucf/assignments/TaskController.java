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

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class TaskController implements Initializable {

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
    ListView<ToDoTask> taskList;

    ObservableList<ToDoTask> ToDoTasks = FXCollections.observableArrayList(new ArrayList<>());

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


    @FXML
    public void markCompleteEvent(Event e){

        taskList.getSelectionModel().selectedItemProperty();

    }


}




