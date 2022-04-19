package com.app.bts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.BillTrackRefNoGenerator;

@Repository
public interface BillTrackRefNoGeneratorRepository extends JpaRepository<BillTrackRefNoGenerator, Long>{

}
