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
    //HI
    int i =0;
    @Test
    public void testRegisterUser() {
        // Valid username and password
        assertTrue(ST10439305POEPART2.registerUser("user_", "Password1!"));

        // Invalid username
        assertFalse(ST10439305POEPART2.registerUser("user", "Password1!"));

        // Invalid password
        assertFalse(ST10439305POEPART2.registerUser("user_", "password"));
    }
     @Test
    public void testCheckUsername() {
        assertTrue(ST10439305POEPART2.checkUsername("user_"));
        assertFalse(ST10439305POEPART2.checkUsername("user"));
        assertFalse(ST10439305POEPART2.checkUsername("username_"));
    }
@Test
    public void testCheckPasswordComplexity() {
        assertTrue(ST10439305POEPART2.checkPasswordComplexity("Password1!"));
        assertFalse(ST10439305POEPART2.checkPasswordComplexity("password"));
        assertFalse(ST10439305POEPART2.checkPasswordComplexity("PASSWORD1!"));
        assertFalse(ST10439305POEPART2.checkPasswordComplexity("Password!"));
        assertFalse(ST10439305POEPART2.checkPasswordComplexity("Password1"));
    }
    
    
}
