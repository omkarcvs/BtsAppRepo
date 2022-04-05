package com.app.bts.service;

import java.util.List;


import com.app.bts.entity.BillFileEntity;

public interface BillFileService {	
	public Long save(BillFileEntity f);	
	public List<BillFileEntity > getAllCreatedBill();
	public List<BillFileEntity > getByNameBillStatus(int billStatus);
	public BillFileEntity getByBillTrackRefNoAndBillStatus(Long billTrackRefNo,int billStatus);
	BillFileEntity getByBillTrackRefNo(Long fileSeq);
	
	public BillFileEntity getCreatedBillById(Long id);
	public void updateBillFile(BillFileEntity f);
	
	
	
}
