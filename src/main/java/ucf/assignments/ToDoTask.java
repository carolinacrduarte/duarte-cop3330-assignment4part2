package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Carolina Duarte
 */

import java.time.LocalDate;

public class ToDoTask {
    //Declarations of attributes regarding the task.
    private String name;
    private LocalDate date;
    private String description;

    //Needed getters and setters.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //ToDoTask function that will be used to define attributes.
    public ToDoTask(String name, LocalDate date, String description) {
        this.setName(name);
        this.setDate(date);
        this.setDescription(description);
    }

    @Override
    public String toString() {
        return "Task name: " + this.getName() + " / " + "Due date: " + this.getDate() + " / " + "Task description: " + this.getDescription();
    }

}

