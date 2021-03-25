package com.example.test.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Handles requesta for adding a student
 */
public class AddStudent
{
    @Getter @Setter private String name;
    @Getter @Setter private String standard;
    @Getter @Setter private String section;
    @Getter @Setter private String roll;

    /**
     * Request format of adding an student
     * @param name
     * @param standard
     * @param section
     * @param roll
     */
    public AddStudent(String name, String standard, String section, String roll)
    {
        this.name       = name;
        this.standard   = standard;
        this.section    = section;
        this.roll       = roll;
    }
}