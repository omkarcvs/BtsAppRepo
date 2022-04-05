package com.app.bts.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BILL_TRACK_TBL")
public class BillTrackEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BILL_TRACK_SEQ")
	@SequenceGenerator(name = "BILL_TRACK_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "BILL_TRACK_SEQ")
	@Column(name="BILL_TRACK_SEQ")
	private Long billTrackSeq;
	
	
	@Column(name="BILL_TRACK_REF_NO")
	private Long billTrackRefNo;
	
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATE_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@CreationTimestamp 
	private LocalDateTime createDate;
	
	@Column(name="FORWARDED_TO")
	private String ForwardedTo;	
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="BILL_STATUS")
	private int billStatus;
	 
	@Column(name="STATUS")
	private String status;
	
	@Column(name="ACTION_ON_BILL")
	private String actionOnBill; /*5: return from received, 6 : return from finance update*/
	
	public Long getBillTrackSeq() {
		return billTrackSeq;
	}

	public void setBillTrackSeq(Long billTrackSeq) {
		this.billTrackSeq = billTrackSeq;
	}

	

	public Long getBillTrackRefNo() {
		return billTrackRefNo;
	}

	public void setBillTrackRefNo(Long billTrackRefNo) {
		this.billTrackRefNo = billTrackRefNo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getForwardedTo() {
		return ForwardedTo;
	}

	public void setForwardedTo(String forwardedTo) {
		ForwardedTo = forwardedTo;
	}

	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(int billStatus) {
		this.billStatus = billStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActionOnBill() {
		return actionOnBill;
	}

	public void setActionOnBill(String actionOnBill) {
		this.actionOnBill = actionOnBill;
	}
	
}
