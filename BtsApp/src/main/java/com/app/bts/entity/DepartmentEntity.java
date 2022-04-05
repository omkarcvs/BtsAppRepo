package com.app.bts.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Department")
public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DEPARTMENT_SEQ")
	@SequenceGenerator(name = "DEPARTMENT_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "DEPARTMENT_SEQ")
	@Column(name="DEPARTMENT_SEQ")
	private Long deptSeq;
	
	@Column(name="DEPT_NUMBER")
	private String deptNumber;
	
	@Column(name="DEPT_NAME")
	private String deptName;
	
	
	
	@Column(name="USER_DTL")
	private String user;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATE_DATE")
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	@CreationTimestamp 
	private LocalDate createDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="UPDATE_DATE")
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	@UpdateTimestamp
	private LocalDate updateDate;
	
	@Column(name="STATUS")
	private String status;

	public Long getDeptSeq() {
		return deptSeq;
	}

	public void setDeptSeq(Long deptSeq) {
		this.deptSeq = deptSeq;
	}

	public String getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
