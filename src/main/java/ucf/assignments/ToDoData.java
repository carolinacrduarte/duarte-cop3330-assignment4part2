package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Carolina Duarte
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class ToDoData {
    private static ToDoData instance = new ToDoData();
    private static String filename = "ToDoListTasks.txt";

    private ObservableList<ToDoTask> ToDoTasks;
    private DateTimeFormatter formatter;

    public static ToDoData getInstance() {

        return instance;
    }

    private ToDoData() {

        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<ToDoTask> getToDoTasks() {

        return ToDoTasks;
    }

    public void addToDoTask(ToDoTask item) {

        ToDoTasks.add(item);
    }

    public void setToDoTasks(List<ToDoTask> ToDoTasks) {

        this.ToDoTasks = (ObservableList<ToDoTask>) ToDoTasks;
    }

    public void loadToDoTasks() throws IOException {

        ToDoTasks  = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String taskName = itemPieces[0];
                String taskDescription = itemPieces[1];
                String dueDateString = itemPieces[2];
                LocalDate dueDate = LocalDate.parse(dueDateString, formatter);

                ToDoTask ToDoTask = new ToDoTask(taskName, dueDate, taskDescription);
                ToDoTasks.add(ToDoTask);
                break;
            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }

    public void storeToDoTasks() throws IOException {

        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<ToDoTask> iterator = ToDoTasks.iterator();
            while (iterator.hasNext()) {
                ToDoTask task = iterator.next();
                bw.write(String.format("%s\t%S\t%s\t%s",
                        task.getName(),
                        task.getDescription(),
                        task.getDate().format(formatter)));
                bw.newLine();
            }

        } finally {
            if(bw != null) {
                bw.close();
            }
        }
    }

    public void deleteToDoTask(ToDoTask task) {
        ToDoTasks.remove(task);
    }
}

