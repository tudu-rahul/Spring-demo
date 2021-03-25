package com.example.test.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * School class which stores details of each student
 */
public class School
{
    @Getter private final String schoolName = "ABC school";
    @Getter @Setter private static HashMap<String, Student> studentsDatabase = new HashMap<String, Student>();

    /**
     * Enrolls a student in school
     * @param student
     */
    public void enroll(Student student)
    {
        this.studentsDatabase.put(student.getRoll(), student);
    }

    /**
     * Updates standard of a student
     * @param standard
     * @param roll
     */
    public void updateStandard(String standard, String roll)
	{
        if (this.studentsDatabase.containsKey(roll))
        {
            Student student = studentsDatabase.get(roll);
            student.setStandard(standard);
            studentsDatabase.replace(roll, student);
        }
    }

    /**
     * Updates name of a student
     * @param name
     * @param roll
     */
    public void updateName(String name, String roll)
    {
        if (this.studentsDatabase.containsKey(roll))
        {
            Student student = studentsDatabase.get(roll);
            student.setName(name);
            studentsDatabase.replace(roll, student);
        }
    }

    /**
     * Updates section of a student
     * @param section
     * @param roll
     */
    public void updateSection(String section, String roll)
    {
        if (this.studentsDatabase.containsKey(roll))
        {
            Student student = studentsDatabase.get(roll);
            student.setSection(section);
            studentsDatabase.replace(roll, student);
        }
    }

    /**
     * Gets details of a student
     * @param roll
     * @return student
     */
    public Student getDetails(String roll)
    {
        System.out.println("Roll input is: " + roll);
        Student student;
        if (this.studentsDatabase.containsKey(roll))
            student = studentsDatabase.get(roll);
        else
            student = new Student("-1","-1","-1");

        return student;
    }

    /**
     * Deletes a student
     * @param roll
     */
	public void deleteStudent(String roll)
	{
	    if (this.studentsDatabase.containsKey(roll))
		    studentsDatabase.remove(roll);
	}
}
