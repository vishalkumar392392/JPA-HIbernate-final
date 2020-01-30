package com.jpa.hibernate.repository.updated;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{

	
}
