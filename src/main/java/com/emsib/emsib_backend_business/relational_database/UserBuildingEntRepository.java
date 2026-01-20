package com.emsib.emsib_backend_business.relational_database;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserBuildingEntRepository extends JpaRepository<UserBuildingEnt, UserBuildingEntId> {
    List<UserBuildingEnt> findByUserId(Integer userId);
}
