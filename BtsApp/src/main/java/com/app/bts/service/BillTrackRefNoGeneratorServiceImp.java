package com.app.bts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bts.dao.BillTrackRefNoGeneratorRepository;
import com.app.bts.entity.BillTrackRefNoGenerator;

@Service
public class BillTrackRefNoGeneratorServiceImp implements BillTrackRefNoGeneratorService {
     
	@Autowired
	BillTrackRefNoGeneratorRepository repo;

	@Override
	public void save() {		
		BillTrackRefNoGenerator e=new BillTrackRefNoGenerator(0l, "SEQ");
		repo.save(e);		
	}
}
