/*
 * package com.jpa.hibernate.repository;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.jpa.hibernate.entity.Student;
 * 
 * @Repository
 * 
 * @Transactional public class StudentRepository {
 * 
 * @Autowired EntityManager em;
 * 
 * public Student findById(Long id) { return em.find(Student.class, id); }
 * 
 * public void deleteById(Long id) { Student student = em.find(Student.class,
 * id); em.remove(student); }
 * 
 * public Student save(Student student) {
 * 
 * if(student.getId()==null) { em.persist(student); } else em.merge(student);
 * return student;
 * 
 * } }
 */