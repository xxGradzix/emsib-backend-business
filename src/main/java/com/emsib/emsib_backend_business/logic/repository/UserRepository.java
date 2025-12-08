package com.emsib.emsib_backend_business.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsib.emsib_backend_business.logic.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
