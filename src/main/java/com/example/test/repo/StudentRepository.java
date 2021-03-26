package com.example.test.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.test.entities.Student;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends CrudRepository<Student, String> {

}