package com.app.bts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BILL_TRACK_REF_NO_TBL")
public class BillTrackRefNoGenerator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BILL_TRACK_REF_NO_SEQ")
	@SequenceGenerator(name = "BILL_TRACK_REF_NO_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "BILL_TRACK_REF_NO_SEQ")
	@Column(name="BILL_TRACK_REF_NO_SEQ")
	private Long billTrackRefNoSeq;	
	@Column(name="NAME")
    String name;
	
	
	
	public BillTrackRefNoGenerator(Long billTrackRefNoSeq, String name) {
		super();
		this.billTrackRefNoSeq = billTrackRefNoSeq;
		this.name = name;
	}
	public BillTrackRefNoGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getBillTrackRefNoSeq() {
		return billTrackRefNoSeq;
	}
	public void setBillTrackRefNoSeq(Long billTrackRefNoSeq) {
		this.billTrackRefNoSeq = billTrackRefNoSeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
