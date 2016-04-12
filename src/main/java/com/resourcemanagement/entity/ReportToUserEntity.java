package com.resourcemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report_to_users")
public class ReportToUserEntity {

	
	@Id
    @GeneratedValue
    @Column(name = "report_id")
    private Long reportId;
	
	@Column(name = "report_to_user_id")
	private Long reportToUserId;
	
	@Column(name = "direct_report",nullable=false)
	private boolean directReport;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "created_at", nullable = false)
	private String createdAt;
	
	@ManyToOne  
	@JoinColumn(name = "user_id",insertable=false, updatable=false,nullable=false)  
	private UserEntity userEntity;  
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="company_id",insertable=false, updatable=false,nullable=false) 
	private CompanyEntity companyEntity;
	
	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Long getReportToUserId() {
		return reportToUserId;
	}

	public void setReportToUserId(Long reportToUserId) {
		this.reportToUserId = reportToUserId;
	}

	public boolean isDirectReport() {
		return directReport;
	}

	public void setDirectReport(boolean directReport) {
		this.directReport = directReport;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
}
