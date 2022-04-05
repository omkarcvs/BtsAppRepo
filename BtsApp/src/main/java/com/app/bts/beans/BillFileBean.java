package com.app.bts.beans;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class BillFileBean {

	private Long file_seq;
	
	private String refNumber;
	private String natureOfClaim;
	private String loaOrPo_Num;
	private String vendorNum;	
	private String invoiceNum;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate invoiceDate;
	private double amount;
	private String remark;
	
	
	private String user;
	private String createdBy;    
	private String createDate;
	private String updatedBy;	
	private String updateDate;
	
	
	
	


	public Long getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(Long file_seq) {
		this.file_seq = file_seq;
	}
	public String getRefNumber() {
		return refNumber;
	}
	
	public String getNatureOfClaim() {
		return natureOfClaim;
	}
	public void setNatureOfClaim(String natureOfClaim) {
		this.natureOfClaim = natureOfClaim;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getLoaOrPo_Num() {
		return loaOrPo_Num;
	}
	public void setLoaOrPo_Num(String loaOrPo_Num) {
		this.loaOrPo_Num = loaOrPo_Num;
	}
	public String getVendorNum() {
		return vendorNum;
	}
	public void setVendorNum(String vendorNum) {
		this.vendorNum = vendorNum;
	}
	public String getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	
	
	
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	
}
