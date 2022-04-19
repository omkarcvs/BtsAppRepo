package com.app.bts.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="BILL_FILE_TBL")
public class BillFileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CREATE_BILL_SEQ")
	@SequenceGenerator(name = "CREATE_BILL_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "CREATE_BILL_SEQ")
	@Column(name="BILL_FILE_SEQ")
	private Long fileSeq;	
	
	@Column(name="BILL_TRACK_REF_NO",unique=true)
	private Long billTrackRefNo;
	
	/*used for DAK */
	@Column(name="INVOIC_NUM")
	private String invoiceNum;
	
	@Column(name="INVOICE_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate invoiceDate;
	
	@Column(name="DAK_RECIPT_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dakReciptDate;
	
	/* Used for Create bill*/
	@Column(name="LOA_OR_PO_NUM")
	private String loaOrPoNum;
	
	@Column(name="LOA_OR_PO_DESCRIPTION")
	private String loaOrPoDescription;
	
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Column(name="VENDOR_TYPE")
	private String vendorType;
	
	@Column(name="VENDOR_GSTIN_NO")
	private String vendorGstinNo;
	
	@Column(name="RA_BILL_NO")
	private String raBillNo;
	
	@Column(name="AMOUNT")
	private String amount;
	
	@Column(name="CURRENCY_TYPE")
	private String currencyType;
	
	//This field will be common for all for remarks
	@Column(name="REMARKs")
	private String remarks;
	
	@Column(name="REASON_FOR_DELAY")
	private String reasonForDelay;
	
	
	
	/*
	 1 => Bill Created
	 2 => Bill dispached
	 3 => Bill recieved
	 4 => Bill closed    
	 */
	@Column(name="BILL_STATUS")
	private int billStatus;
	
	/*  Used for dispatching                       */
	
	 @Column(name="DEPT_DESSTINATION")
	 private String deptDestination;
	    
	 @Column(name="ADDRESSED_EMP")
	 private String addressedEmp;
	
	/* Bill Clossing */
	 
	  @Column(name="PAYMENT_MODE")
	  private String paymentMode;
	  @Column(name="PAYMENT_BOUCHER_OR_CHEQUE_NO")
	  private String paymentVoucherOrChequeNo;
	  @Column(name="PAYMENT_DATE")
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	  private LocalDate paymentDate;
	 
	  
	  
	  @Column(name="SECURITY_DEPOSIT")
	  private Double securityDeposit;
	  @Column(name="RETENTION_RELEASED_AMOUNT")
	  private Double retentionReleasedAmount;
	  @Column(name="LESS_INCOME_TAX_TDS")
	  private Double lessIncomeTaxTds;
	  
	  
	  @Column(name="LESS_CGST_TDS")
	  private Double lessCgstTds;
	  
	  @Column(name="LESS_SGST_TDS")
	  private Double lessSgstTds;
	  
	  @Column(name="LESS_IGST_TDS")
	  private Double lessIgstTds;
	  
	  @Column(name="LESS_RETENTION_GST_AMOUNT")
	  private Double lessRetentionGstAmount;
	  
	  @Column(name="LESS_SD_AS_PER_LOA_PO_AMOUNT")
	  private Double lessSdAsPerLoaPoAmount;
	  
	  @Column(name="NET_AMT")
	  private Double netAmt;
	  
	 
	/*billow is the common field*/
	/*-----------------------------------------------------------------------------*/
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATE_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@CreationTimestamp 
	private LocalDateTime  createDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATE_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@UpdateTimestamp
	private LocalDateTime updateDate;
	//It will A or S
	@Column(name="STATUS")
	private String status;
	
	@Column(name="ACTION_ON_BILL")
	private String actionOnBill; /*5: return from received, 6 : return from finance update*/
	/*getter Setter*/
	
	public Long getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(Long fileSeq) {
		this.fileSeq = fileSeq;
	}
	public Long getBillTrackRefNo() {
		return billTrackRefNo;
	}
	public void setBillTrackRefNo(Long billTrackRefNo) {
		this.billTrackRefNo = billTrackRefNo;
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
	public String getLoaOrPoNum() {
		return loaOrPoNum;
	}
	public void setLoaOrPoNum(String loaOrPoNum) {
		this.loaOrPoNum = loaOrPoNum;
	}
	public String getLoaOrPoDescription() {
		return loaOrPoDescription;
	}
	public void setLoaOrPoDescription(String loaOrPoDescription) {
		this.loaOrPoDescription = loaOrPoDescription;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getVendorGstinNo() {
		return vendorGstinNo;
	}
	public void setVendorGstinNo(String vendorGstinNo) {
		this.vendorGstinNo = vendorGstinNo;
	}
	public String getRaBillNo() {
		return raBillNo;
	}
	public void setRaBillNo(String raBillNo) {
		this.raBillNo = raBillNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
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
	public String getDeptDestination() {
		return deptDestination;
	}
	public void setDeptDestination(String deptDestination) {
		this.deptDestination = deptDestination;
	}
	public String getAddressedEmp() {
		return addressedEmp;
	}
	public void setAddressedEmp(String addressedEmp) {
		this.addressedEmp = addressedEmp;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentVoucherOrChequeNo() {
		return paymentVoucherOrChequeNo;
	}
	public void setPaymentVoucherOrChequeNo(String paymentVoucherOrChequeNo) {
		this.paymentVoucherOrChequeNo = paymentVoucherOrChequeNo;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getSecurityDeposit() {
		return securityDeposit;
	}
	public void setSecurityDeposit(Double securityDeposit) {
		this.securityDeposit = securityDeposit;
	}
	public Double getRetentionReleasedAmount() {
		return retentionReleasedAmount;
	}
	public void setRetentionReleasedAmount(Double retentionReleasedAmount) {
		this.retentionReleasedAmount = retentionReleasedAmount;
	}
	public Double getLessIncomeTaxTds() {
		return lessIncomeTaxTds;
	}
	public void setLessIncomeTaxTds(Double lessIncomeTaxTds) {
		this.lessIncomeTaxTds = lessIncomeTaxTds;
	}
	public Double getLessCgstTds() {
		return lessCgstTds;
	}
	public void setLessCgstTds(Double lessCgstTds) {
		this.lessCgstTds = lessCgstTds;
	}
	public Double getLessSgstTds() {
		return lessSgstTds;
	}
	public void setLessSgstTds(Double lessSgstTds) {
		this.lessSgstTds = lessSgstTds;
	}
	public Double getLessIgstTds() {
		return lessIgstTds;
	}
	public void setLessIgstTds(Double lessIgstTds) {
		this.lessIgstTds = lessIgstTds;
	}
	public Double getLessRetentionGstAmount() {
		return lessRetentionGstAmount;
	}
	public void setLessRetentionGstAmount(Double lessRetentionGstAmount) {
		this.lessRetentionGstAmount = lessRetentionGstAmount;
	}
	public Double getLessSdAsPerLoaPoAmount() {
		return lessSdAsPerLoaPoAmount;
	}
	public void setLessSdAsPerLoaPoAmount(Double lessSdAsPerLoaPoAmount) {
		this.lessSdAsPerLoaPoAmount = lessSdAsPerLoaPoAmount;
	}
	public Double getNetAmt() {
		return netAmt;
	}
	public void setNetAmt(Double netAmt) {
		this.netAmt = netAmt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDakReciptDate() {
		return dakReciptDate;
	}
	public void setDakReciptDate(LocalDate dakReciptDate) {
		this.dakReciptDate = dakReciptDate;
	}
	public String getReasonForDelay() {
		return reasonForDelay;
	}
	public void setReasonForDelay(String reasonForDelay) {
		this.reasonForDelay = reasonForDelay;
	}
	public String getActionOnBill() {
		return actionOnBill;
	}
	public void setActionOnBill(String actionOnBill) {
		this.actionOnBill = actionOnBill;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
	
}
