package com.app.bts.service;

import java.util.List;

import com.app.bts.entity.BillTrackEntity;


public interface BillTrackService {
	public List<BillTrackEntity> getByBillTrackRefNo(Long billTrackRefNo);
	public void saveBillTrackEntity(BillTrackEntity billTrackEntity);
}
