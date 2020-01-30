//package com.jpa.hibernate.repository;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.jpa.hibernate.entity.Passport;
//import com.jpa.hibernate.entity.Student;
//import com.jpa.hibernate.repository.updated.PassportRepository;
//import com.jpa.hibernate.repository.updated.StudentRepository;
//
//@Component
//@Transactional
//public class EntityRepository {
//	
//	@Autowired
//	private PassportRepository passportRepository;
//	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	public Student saveStudent() {
//		
//		Passport passport = new Passport("K154564");
//		
//		passportRepository.save(passport);
//		
//		Student student = new Student("vishal");
//		
//		student.setPassport(passport);
//		
//		studentRepository.save(student);
//		
//		return student;
//		
//	}
//	
//	
//	public Optional<Student> findById(Long id) {
//		
//		return studentRepository.findById(id);
//	}
//
//}
