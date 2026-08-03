package com.ypc.book_my_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ypc.book_my_ticket.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByEmail(String email);
	void deleteByRole(String role);
}
