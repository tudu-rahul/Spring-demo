package com.example.test;

import com.example.test.entities.School;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.test.entities.Student;
import com.example.test.repo.StudentRepository;
import com.example.test.request.AddStudent;
import com.example.test.response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller
{
	@Autowired
	private StudentRepository studentRepository;
	// health checkup
	@GetMapping("/health")
	public Response<String> greeting()
	{
		return new Response<>(200, "Service is up");
	}

	/**
	 * Adds a student
	 * @param addStudent
	 * @return roll number
	 */
	@PostMapping(path = "/addstudent")
	public Response<HashMap<String, String>> addMember(@RequestBody AddStudent addStudent)
	{
		Student student = new Student(addStudent.getName(), addStudent.getStandard(), addStudent.getSection(), addStudent.getRoll());

		/*
		School school	= new School();
		school.enroll(student);
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("roll", student.getRoll());
		 */

		studentRepository.save(student);
		HashMap<String, String> data = new HashMap<>();
		data.put("roll", student.getRoll());

		return new Response<>(200, data, "Student added");
	}

	/**
	 * Updates name of a student
	 * @param roll
	 * @param name
	 * @return response
	 */
	@PutMapping(path = "/updatename/{roll}/{name}")
	public Response<String> updateName(@PathVariable(value = "roll") String roll, @PathVariable(value = "name") String name)
	{
		/*
		School school = new School();
		school.updateName(name, roll);
		 */

		Student student = studentRepository.findById(roll).get();
		student.setName(name);
		studentRepository.save(student);

		return new Response<>(200, "Name updated");
	}

	/**
	 * Updates standard of a student
	 * @param roll
	 * @param standard
	 * @return response
	 */
	@PutMapping(path = "/updatestandard/{roll}/{standard}")
	public Response<String> updateStandard(@PathVariable(value = "roll") String roll, @PathVariable(value = "standard") String standard)
	{
		/*
		School school = new School();
		school.updateStandard(standard, roll);
		 */

		Student student = studentRepository.findById(roll).get();
		student.setStandard(standard);
		studentRepository.save(student);

		return new Response<>(200, "Standard updated");
	}

	/**
	 * Updates section of a student
	 * @param roll
	 * @param section
	 * @return response
	 */
	@PutMapping(path = "/updatesection/{roll}/{section}")
	public Response<String> updateSection(@PathVariable(value = "roll") String roll, @PathVariable(value = "section") String section)
	{
		/*
		School school = new School();
		school.updateSection(section, roll);
		 */

		Student student = studentRepository.findById(roll).get();
		student.setSection(section);
		studentRepository.save(student);

		return new Response<>(200, "Section updated");
	}

	/**
	 * Gets details of a student
	 * @param roll
	 * @return response
	 */
	@GetMapping("/getdetails")
	public Response<Student> getdetails(@RequestParam(value = "roll") String roll)
	{
		/*
		School school = new School();
		Student student	= school.getDetails(roll);
		 */

		Student student = studentRepository.findById(roll).get();

		return new Response<Student>(200, student, "Student details fetched");
	}

	/**
	 * Deletes a student
	 * @param roll
	 * @return response
	 */
	@DeleteMapping(path = "/deletestudent/{roll}")
	public Response<String> deletestudent(@PathVariable(value = "roll") String roll)
	{
		/*
		School school = new School();
		school.deleteStudent(roll);
		 */

		studentRepository.delete(studentRepository.findById(roll).get());

		return new Response<>(200, "Student deleted");
	}
}
