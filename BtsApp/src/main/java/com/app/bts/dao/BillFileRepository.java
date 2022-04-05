package com.app.bts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.BillFileEntity;


@Repository
public interface BillFileRepository  extends JpaRepository<BillFileEntity, Long>{
	@Query(value = "SELECT BILL_TRACK_REF_NO_SEQ.nextval FROM dual", nativeQuery =true)
	Long getBillTrackRefNoSeq();
	
	/* Select * from BillFile where billStatus=? */
	List<BillFileEntity> findByBillStatus(int billStatus);
	List<BillFileEntity> findByBillTrackRefNoAndBillStatus(Long fileSeq,int billStatus);
	List<BillFileEntity> findByBillTrackRefNo(Long fileSeq);
	
	 
}
