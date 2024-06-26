/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10439305.poe.part2;

/**
 *
 * @author qays2
 */
class Task {
    private static int taskCount = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskCount++;
        this.taskID = generateTaskID();
    }
      /*  According to Niraj(2023) the toUpperCase method in java converts all characters of the string into an uppercase letter 
          it help me convert the user's input for the taskID into capital letters.
    
         According to Anon(2022) substring in java provides the built-in substring() method that extract a substring from the given string 
         This helped me return a substring instead of a full word for the ID.
    */
    private String generateTaskID() {
        String[] devInitials = developerDetails.split(" ");
        String devID = devInitials[devInitials.length - 1].substring(0, 3).toUpperCase();
        String taskIDPrefix = taskName.substring(0, 2).toUpperCase();
        return String.format("%s:%d:%s", taskIDPrefix, taskNumber, devID);
    }
public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    // Getter method for task duration
    public int getTaskDuration() {
     
       return taskDuration;
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }
  }



    
    
    


    
    