/*
 * package com.jpa.hibernate.repository;
 * 
 * import static org.junit.Assert.assertNull; import static
 * org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.annotation.DirtiesContext; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.jpa.hibernate.JpaHIbernateApplication; import
 * com.jpa.hibernate.entity.Course;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest(classes = JpaHIbernateApplication.class) class
 * CourseRepositoryTests {
 * 
 * @Autowired CourseRepository repo;
 * 
 * @Test void findById() { Course course = repo.findById(10001L);
 * 
 * assertEquals("Jpa Course", course.getName()); }
 * 
 * @Test
 * 
 * @DirtiesContext void deleteById() { repo.deleteById(10002L);
 * assertNull(repo.findById(10002L)); }
 * 
 * public void save() {
 * 
 * Course course = repo.findById(10001L);
 * 
 * assertEquals("Jpa Course", course.getName());
 * 
 * course.setName("Jpa Course -> updated");
 * 
 * assertEquals("Jpa Course -> updated", course.getName());
 * 
 * }
 * 
 * }
 */