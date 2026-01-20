package com.emsib.emsib_backend_business.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsib.emsib_backend_business.logic.entity.UserEnt;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEnt, Long>{
    Optional<UserEnt> findById(Long id);
    List<UserEnt> findAll();
}
