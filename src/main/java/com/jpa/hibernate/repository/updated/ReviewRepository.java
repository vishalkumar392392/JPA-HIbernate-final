package com.jpa.hibernate.repository.updated;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.hibernate.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
