package com.example.test.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * Student class
 */
public class Student {

    @Getter @Setter private String name;
    @Getter @Setter private String standard;
    @Getter @Setter private String section;
    @Getter @Setter private String roll;

    /**
     * Constructor for the student class with a roll number
     * @param name
     * @param standard
     * @param section
     * @param roll
     */
    public Student(String name, String standard, String section, String roll)
    {
        this.name       = name;
        this.standard   = standard;
        this.section    = section;
        this.roll       = generateId();
    }

    /**
     * Constructor for the student class without roll number
     * @param name
     * @param standard
     * @param section
     */
    public Student(String name, String standard, String section)
    {
        this.name       = name;
        this.standard   = standard;
        this.section    = section;
        this.roll       = "";
    }

    /**
     * Generates a random roll number
     * @return id
     */
    public String generateId()
    {
        Random rand = new Random(System.currentTimeMillis());
        String id = "";
        for(int i = 0; i < 5; i++)
        {
            id = id + rand.nextInt(10);
        }
        return id;
    }
}
