package com.app.bts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.BillTrackEntity;

@Repository
public interface BillTrackRepository extends JpaRepository<BillTrackEntity, Long> {
	List<BillTrackEntity> findByBillTrackRefNo(Long billTrackRefNo);
}
