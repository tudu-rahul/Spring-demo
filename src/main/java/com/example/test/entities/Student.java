package com.example.test.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

/**
 * Student class
 */
@Entity
public class Student {

    @Getter @Setter private String name;
    @Getter @Setter private String standard;
    @Getter @Setter private String section;
    @Id
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

    public Student() {

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
