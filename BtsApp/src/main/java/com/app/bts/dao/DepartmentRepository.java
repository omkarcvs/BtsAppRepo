package com.app.bts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.DepartmentEntity;
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
