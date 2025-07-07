package com.example.BookApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookApplication.model.PathModel;
import com.example.BookApplication.model.UserPathModel;

@Repository
public interface UserRepository extends JpaRepository<UserPathModel,Long> {

	
}
