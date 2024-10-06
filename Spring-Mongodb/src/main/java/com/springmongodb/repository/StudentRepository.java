package com.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmongodb.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
