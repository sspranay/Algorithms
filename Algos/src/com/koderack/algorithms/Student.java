package com.koderack.algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pranay pramod
 */
public class Student {
    private String name;
    private int UIN;

    public Student(String name, int UIN) {
        this.name = name;
        this.UIN = UIN;
    }
    
    public String toString(){
        return name + " --" + UIN;
    }

    @Override
    public boolean equals(Object otherStudent){
        boolean result = false;
        if(otherStudent instanceof Student){
            Student otherStudent1 = (Student)otherStudent;
            result = (this.name.equalsIgnoreCase(otherStudent1.name) && this.UIN == otherStudent1.UIN);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.UIN;
        return hash;
    }
    
    
}
class DemoStudent {
    public static void main(String[] args){
            HashMap<Integer, Student> hm = new HashMap<>();
            Student s1 = new Student("Pranay", 10001);
            Student s2 = new Student("Pranay", 10001);
            hm.put(1, s1);
            hm.put(2,s2);
            hm.remove(1);
            System.out.println(hm.toString());
            System.out.println(s1.equals(s2));
        }
}
