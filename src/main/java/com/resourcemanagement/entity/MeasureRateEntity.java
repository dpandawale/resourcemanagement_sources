package com.resourcemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "measure_rate")
public class MeasureRateEntity {
	
	@Id
    @GeneratedValue
    @Column(name = "measure_rate_id")
    private Long measureRateCountId;
	
	@Column(name = "choice")
	private Long choice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CompanyEntity companyEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	private MeasureEntity measureEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserEntity userEntity;
	
	@Column(name = "created_at",nullable=false)
	private String createdAt;
	
	@Column(name = "updated_at",nullable=false)
	private String updatedAt;
	
	@Column(name = "status")
	private Integer status;

	public Long getMeasureRateCountId() {
		return measureRateCountId;
	}

	public void setMeasureRateCountId(Long measureRateCountId) {
		this.measureRateCountId = measureRateCountId;
	}

	public Long getChoice() {
		return choice;
	}

	public void setChoice(Long choice) {
		this.choice = choice;
	}

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}

	public MeasureEntity getMeasureEntity() {
		return measureEntity;
	}

	public void setMeasureEntity(MeasureEntity measureEntity) {
		this.measureEntity = measureEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
