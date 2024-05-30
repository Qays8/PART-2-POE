/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10439305.poe.part2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author qays2
 */
public class ST10439305POEPART2TEST {
    
    public ST10439305POEPART2TEST() {
    }
    @Test
    public void testTaskDescriptionLength() {
        Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription(), "Description within limit should pass.");

        Task longDescriptionTask = new Task("Add Task Feature", "This description is way too long and should trigger an error message", "Mike Smith", 10, "Doing");
        assertFalse(longDescriptionTask.checkTaskDescription(), "Description exceeding limit should fail.");
    }

    
    public void testGenerateTaskID() {
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task1.printTaskDetails().contains("Task ID: LO:0:SON"));

        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add task  users", "Mike Smith", 10, "Doing");
        assertTrue(task2.printTaskDetails().contains("Task ID: AD:1:ITH"));
    }

    @Test
    public void testPrintTaskDetails() {
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        String taskDetails1 = task1.printTaskDetails();
        assertTrue(taskDetails1.contains("Task Status: To Do"));
        assertTrue(taskDetails1.contains("Developer Details: Robyn Harrison"));
        assertTrue(taskDetails1.contains("Task Number: 0"));
        assertTrue(taskDetails1.contains("Task Name: Login Feature"));
        assertTrue(taskDetails1.contains("Task Description: Create Login to authenticate users"));
        assertTrue(taskDetails1.contains("Task ID: LO:0:SON"));
        assertTrue(taskDetails1.contains("Task Duration: 8.0 hours"));
    }

    @Test
    public void testTotalHoursAccumulation() {
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add task  users", "Mike Smith", 10, "Doing");

        int totalHours = task1.getTaskDuration() + task2.getTaskDuration();
        assertEquals(18, totalHours, "Total hours for 2 tasks should be 18.");
    }
}