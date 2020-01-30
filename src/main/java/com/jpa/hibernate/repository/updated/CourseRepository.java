package com.jpa.hibernate.repository.updated;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.hibernate.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	@Query("select distinct c from Course c join c.students s where s.id=?1 ")
	public List<Course> findCoursesByStudentId(Long id);
	
	
//	@Query("select distinct co from Course co where co.id<>(select distinct c from Course c join c.students s where s.id=?1) ")
	@Query("select distinct co from Course co where co.id NOT IN((select distinct c from Course c join c.students s where s.id=?1)) ")
	public List<Course> findNotEnrolledCoursesByStudentId(Long id);



}
