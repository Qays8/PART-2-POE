/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10439305.poe.part2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author qays2
 */
public class ST10439305POEPART2 {
   
    public static void main(String[] args) {
        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // User registration
        String username = JOptionPane.showInputDialog("ENTER SURNAME:");
        String password = JOptionPane.showInputDialog("ENTER PASSWORD:");

        // Registration logic
        boolean registrationSuccess = registerUser(username, password);
        if (!registrationSuccess) {
            JOptionPane.showMessageDialog(null, "Registration failed. Exiting.");
            return;
        }

        // Menu options
        int choice;
        boolean exit = false;
        while (!exit) {
            choice = Integer.parseInt(JOptionPane.showInputDialog("Select an option:\n1. Add Task\n2. Show Report (Coming Soon)\n3. Quit"));

             if (choice == 1) {
                addTask();
            } else if (choice == 2) {
                JOptionPane.showMessageDialog(null, "Report feature is still in development. Coming soon.");
            } else if (choice == 3) {
                JOptionPane.showMessageDialog(null, "Exiting EasyKanban");
                exit = true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    // Method to add task
    private static void addTask() {
        int numTasks = 0;
        while (numTasks <= 0) {
            try {
                numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                if (numTasks <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive integer greater than zero.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
            }
        }

        Task[]tasks = new Task[numTasks];
        int totalHours = 0;
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            String developerDetails = JOptionPane.showInputDialog("Enter Developer Details:");

            int taskDuration = 0;
            while (taskDuration <= 0) {
                try {
                    taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (hours):"));
                    if (taskDuration <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive integer greater than zero for task duration.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer for task duration.");
                }
            }

            String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do, Done, Doing):");

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            tasks[i] = task;
            totalHours += task.getTaskDuration();
            JOptionPane.showMessageDialog(null, "Task successfully captured:\n" + task.printTaskDetails());
        }

        // Display total hours
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    // Method to register user
    public static boolean registerUser(String username, String password) {
        // Check username and password complexity
        boolean validUsername = checkUsername(username);
        boolean validPassword = checkPasswordComplexity(password);
        return validUsername && validPassword;
    }

    // Method to check username complexity
    public static boolean checkUsername(String username) {
        // Check if the username contains an underscore and is no more than 5 characters in length
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public static boolean checkPasswordComplexity(String password) {
        // Check password complexity criteria (e.g., minimum length, uppercase, lowercase, digits, special characters)
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&()].*");
    }
}


