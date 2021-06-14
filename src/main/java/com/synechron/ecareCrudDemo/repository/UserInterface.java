package com.synechron.ecareCrudDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synechron.ecareCrudDemo.model.User;

public interface UserInterface extends JpaRepository<User, Long>{

}
