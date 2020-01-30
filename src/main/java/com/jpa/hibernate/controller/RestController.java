package com.jpa.hibernate.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jpa.hibernate.entity.Course;
import com.jpa.hibernate.entity.Passport;
import com.jpa.hibernate.entity.Review;
import com.jpa.hibernate.entity.Student;
import com.jpa.hibernate.exception.UserNotFoundException;
import com.jpa.hibernate.repository.updated.CourseRepository;
import com.jpa.hibernate.repository.updated.PassportRepository;
import com.jpa.hibernate.repository.updated.ReviewRepository;
import com.jpa.hibernate.repository.updated.StudentRepository;
@CrossOrigin(origins = "http://localhost:4200")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private PassportRepository passportRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	private Logger logger;
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable("id") Long id){
		
		Student student =  studentRepository.findById(id).orElseThrow(()->{
			throw new UserNotFoundException("there is no student with :"+id);
		});
		
		
		return student;
	}

	@GetMapping("/passports")
	public List<Passport> getPassports(){
		
		return passportRepository.findAll();
	}
	
	@GetMapping("/students/courses")
	public List<Course> getCourses(){
		
		return courseRepository.findAll();
	}
	
	@GetMapping("/students/courses/{id}")
	public Course getCoursesById(@PathVariable("id") Long id){
		
		Course course =  courseRepository.findById(id).orElseThrow(()->{
			throw new UserNotFoundException("there is no Course with :"+id);
		});

		return course;
	}
	
	
	
	@PostMapping(path="/students")
	public Student createStudent(@RequestBody Student student) {
		
		passportRepository.save(student.getPassport());
		return studentRepository.save(student);
		
	}
	@PostMapping(path="/students/courses")
	public Course createCourse(@RequestBody Course course) {
		
		return courseRepository.save(course);
		
	}
	
	/* To add a review to a course */
	
	@PostMapping(path="/students/courses/review/{id}")
	public Course createReview(@RequestBody Review review, @PathVariable("id") Long id) {
		
		
		Optional<Course> optionalCourse = courseRepository.findById(id);
		Course course = optionalCourse.get();
		review.setCourse(course);
		reviewRepository.save(review);
		return course;	
	}

	/* To enroll to a
	 *  particular course */
	@GetMapping(path="/students/courses/{student_id}/{course_id}")
	public Course getEnrolledInCourse(@PathVariable("student_id") Long student_id,@PathVariable("course_id") Long course_id) {
		
		Optional<Student> optionalStudent = studentRepository.findById(student_id);
		Student student = optionalStudent.get();
		
		Optional<Course> optionalCourse = courseRepository.findById(course_id);
		Course course = optionalCourse.get();
		
		course.getStudents().add(student);
		student.getCourses().add(course);
		
		courseRepository.save(course);
		
		return course;
		
	}
	
	/*
	 * 
	 *  To know the courses enrolled by the student using student id
	 *  
	 *  */
	
	@GetMapping(path="students/{student_id}/courses")
	public List<Course> getCourses(@PathVariable("student_id") Long student_id){
		
		
		logger = LoggerFactory.getLogger(getClass());
		
		logger.info("{}", courseRepository.findCoursesByStudentId(student_id));
		
		return  courseRepository.findCoursesByStudentId(student_id);
		
	}
	
	
	@GetMapping(path="students/{student_id}/courses/not_enrolled")
	public List<Course> getCoursesNotEnrolled(@PathVariable("student_id") Long student_id){
	
		
		return  courseRepository.findNotEnrolledCoursesByStudentId(student_id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
