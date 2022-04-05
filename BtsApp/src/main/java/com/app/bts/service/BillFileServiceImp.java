package com.app.bts.service;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bts.dao.BillFileRepository;
import com.app.bts.entity.BillFileEntity;
import com.app.bts.entity.BillTrackEntity;

@Service
public class BillFileServiceImp implements BillFileService {

	@Autowired
	BillFileRepository billFileRepo;
	
	@Autowired
	BillTrackService billTrackService;
	
	@Override
	public Long save(BillFileEntity billFileEntity) {
		
		//System.out.println("DAK_REF_SEQ : "+dakRepo.getNextDakRefSeq());
		 Long BillTrackRefNo=billFileRepo.getBillTrackRefNoSeq();
		 billFileEntity.setBillTrackRefNo(BillTrackRefNo);

		 // Preparing data for BillTacking
		 BillTrackEntity billTrackEntity=new BillTrackEntity();
		 billTrackEntity.setCreatedBy(billFileEntity.getCreatedBy());
		 billTrackEntity.setBillTrackRefNo(billFileEntity.getBillTrackRefNo());		 
		 billTrackEntity.setRemarks(billFileEntity.getRemarks());	
		 billTrackEntity.setActionOnBill(billFileEntity.getActionOnBill());
		 billFileRepo.save(billFileEntity);
		 billTrackService.saveBillTrackEntity(billTrackEntity);
		 return BillTrackRefNo;
		
	}

	@Override
	public List<BillFileEntity> getAllCreatedBill() {		
		return billFileRepo.findAll();
	}
	
	@Override
	public BillFileEntity getCreatedBillById(Long id) {		
		return billFileRepo.findById(id).get();
	}

	@Override
	public void updateBillFile(BillFileEntity billFileEntity) {
		 System.out.println(" action On bill : "+billFileEntity.getActionOnBill());
		 System.out.println(" billFileEntity.getBillStatus(): "+billFileEntity.getBillStatus());
		 System.out.println(" billFileEntity.getBillTrackRefNo(): "+billFileEntity.getBillTrackRefNo());
		BillFileEntity loadEntity=billFileRepo.findByBillTrackRefNoAndBillStatus(billFileEntity.getBillTrackRefNo(),(billFileEntity.getBillStatus()-1)).get(0);
		BillTrackEntity billTrackEntity=new BillTrackEntity();
		
		boolean flag =false;
		
		switch(billFileEntity.getBillStatus())
		{ 
		  case 1:  loadEntity=createBill(loadEntity,billFileEntity); flag=true;
		           break;
		  case 2:  loadEntity=dispatchBill(loadEntity,billFileEntity); flag=true;
		  		   break;
		  case 3:  loadEntity=receiveBill(loadEntity,billFileEntity); flag=true;
		  		   break;
		  case 4: loadEntity=closeBill(loadEntity,billFileEntity); flag=true;
		  		   break;		
		  }	
		
		 if(flag)
		 {
			 System.out.println(" action On bill : "+billFileEntity.getActionOnBill().equals("5"));
			 
			 billTrackEntity.setCreatedBy(billFileEntity.getCreatedBy());
			 billTrackEntity.setBillTrackRefNo(billFileEntity.getBillTrackRefNo());			 
			 billTrackEntity.setBillStatus(billFileEntity.getBillStatus());
			 billTrackEntity.setActionOnBill(billFileEntity.getActionOnBill());
			 
			 if(billFileEntity.getActionOnBill().equals("5")) {
				 billTrackEntity.setRemarks("Returned from Recieving bill");
				 loadEntity.setBillStatus(0);
			 }else if(billFileEntity.getActionOnBill().equals("6")) {
				 loadEntity.setBillStatus(0);
				 billTrackEntity.setRemarks("Returned from Finance Update");
			 }else {
				 billTrackEntity.setRemarks(billFileEntity.getRemarks());
			 }
			 
			 billFileRepo.save(loadEntity);				 
		     billTrackService.saveBillTrackEntity(billTrackEntity);
		 }
	}

	@Override
	public List<BillFileEntity> getByNameBillStatus(int billStatus) {		
		return billFileRepo.findByBillStatus(billStatus);
	}


	  @Override 
	  public BillFileEntity getByBillTrackRefNoAndBillStatus(Long billTrackRefNo, int billStatus) {	 
	     return billFileRepo.findByBillTrackRefNoAndBillStatus(billTrackRefNo,billStatus).get(0);
	  }
	  @Override
		public BillFileEntity getByBillTrackRefNo(Long billTrackRefNo) {			
		  return billFileRepo.findByBillTrackRefNo(billTrackRefNo).get(0);
		}
		  
	  
	  //For Creating new Bill
	  public BillFileEntity createBill(BillFileEntity loadEntity,BillFileEntity billFileEntity)//billStatus 0->1
	  {

			loadEntity.setLoaOrPoNum(billFileEntity.getLoaOrPoNum());
			loadEntity.setLoaOrPoDescription(billFileEntity.getLoaOrPoDescription());
			loadEntity.setVendorName(billFileEntity.getVendorName());
			loadEntity.setVendorType(billFileEntity.getVendorType());
			loadEntity.setVendorGstinNo(billFileEntity.getVendorGstinNo());
			loadEntity.setRaBillNo(billFileEntity.getRaBillNo());
			loadEntity.setAmount(billFileEntity.getAmount());
			loadEntity.setCurrencyType(billFileEntity.getCurrencyType());
			loadEntity.setRemarks(billFileEntity.getRemarks());		
			loadEntity.setBillStatus(billFileEntity.getBillStatus());	
			loadEntity.setReasonForDelay(billFileEntity.getReasonForDelay());	
		    return loadEntity;
	  }
	  
	  //For dispatch Bill
	  public BillFileEntity dispatchBill(BillFileEntity loadEntity,BillFileEntity billFileEntity)//billStatus 1->2
	  {

			loadEntity.setDeptDestination(billFileEntity.getDeptDestination());
			loadEntity.setAddressedEmp(billFileEntity.getAddressedEmp());			
			loadEntity.setRemarks(billFileEntity.getRemarks());		
			loadEntity.setBillStatus(billFileEntity.getBillStatus());		  
		    return loadEntity;
	  }
	  //For receive Bill
	  public BillFileEntity receiveBill(BillFileEntity loadEntity,BillFileEntity billFileEntity)//billStatus 2->3
	  {				
			loadEntity.setRemarks(billFileEntity.getRemarks());		
			loadEntity.setBillStatus(billFileEntity.getBillStatus());		  
		    return loadEntity;
	  }
	  
	  //For close Bill
	  public BillFileEntity closeBill(BillFileEntity loadEntity,BillFileEntity billFileEntity)//billStatus 3->4
	  {			
		  
		  loadEntity.setPaymentMode(billFileEntity.getPaymentMode());
		  loadEntity.setPaymentVoucherOrChequeNo(billFileEntity.getPaymentVoucherOrChequeNo());
		  loadEntity.setPaymentDate(billFileEntity.getPaymentDate());
		  loadEntity.setSecurityDeposit(billFileEntity.getSecurityDeposit());
		  loadEntity.setRetentionReleasedAmount(billFileEntity.getRetentionReleasedAmount());
		  loadEntity.setLessIncomeTaxTds(billFileEntity.getLessIncomeTaxTds());
		  
		  loadEntity.setLessCgstTds(billFileEntity.getLessCgstTds());
		  loadEntity.setLessSgstTds(billFileEntity.getLessSgstTds());
		  loadEntity.setLessIgstTds(billFileEntity.getLessIgstTds());
		  loadEntity.setLessRetentionGstAmount(billFileEntity.getLessRetentionGstAmount());
		  loadEntity.setLessSdAsPerLoaPoAmount(billFileEntity.getLessSdAsPerLoaPoAmount());
		  loadEntity.setNetAmt(billFileEntity.getNetAmt());
		 		  
		  loadEntity.setRemarks(billFileEntity.getRemarks());		
		  loadEntity.setBillStatus(billFileEntity.getBillStatus());		  
		  return loadEntity;
	  }
	  public BillFileEntity returnBillBeforeClose(BillFileEntity loadEntity,BillFileEntity billFileEntity)//billStatus ...
	  {
		  return null;
	  }

	
	

}
