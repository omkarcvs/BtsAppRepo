package com.app.bts.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bts.dao.BillTrackRepository;
import com.app.bts.entity.BillTrackEntity;


@Service
public class BillTrackServiceImp implements BillTrackService{

	@Autowired
	BillTrackRepository billTrackRepo;
	
	@Override
	public List<BillTrackEntity> getByBillTrackRefNo(Long billTrackRefNo) {
		// TODO Auto-generated method stub
		//return billTrackRepo.findByBillTrackRefNo(billTrackRefNo);
		
		Comparator<BillTrackEntity> c=(t1,t2)->t1.getBillTrackSeq().compareTo(t2.getBillTrackSeq());//c and c1 both are the same
		//Comparator<BillTrackEntity> c1=Comparator.comparing(BillTrackEntity::getBillTrackRefNo);
		/*List<BillTrackEntity> tt= billTrackRepo.findByBillTrackRefNo(billTrackRefNo).stream().sorted(c).collect(Collectors.toList());*/
		//return billTrackRepo.findByBillTrackRefNo(billTrackRefNo).stream().sorted(c).collect(Collectors.toList()); or
		return billTrackRepo.findByBillTrackRefNo(billTrackRefNo).stream().sorted(Comparator.comparing(BillTrackEntity::getBillTrackRefNo)).collect(Collectors.toList());
		 
	}

	@Override
	public void saveBillTrackEntity(BillTrackEntity dakEntity) {
		billTrackRepo.save(dakEntity);
		
	}

}
