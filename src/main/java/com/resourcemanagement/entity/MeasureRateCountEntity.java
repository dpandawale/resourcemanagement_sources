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
@Table(name = "measure_rate_count")
public class MeasureRateCountEntity {

	@Id
	@GeneratedValue
	@Column(name = "measure_rate_id")
	private Long measureRateCountId;

	@ManyToOne(cascade = CascadeType.ALL)
	private CompanyEntity companyEntity;

	@OneToOne(cascade = CascadeType.ALL)
	private MeasureRateEntity measureRateEntity;
	
	@Column(name = "choice_code")
	private Long choiceCodeCount;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserEntity userEntity;

	public Long getMeasureRateCountId() {
		return measureRateCountId;
	}

	public void setMeasureRateCountId(Long measureRateCountId) {
		this.measureRateCountId = measureRateCountId;
	}

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}

	public MeasureRateEntity getMeasureRateEntity() {
		return measureRateEntity;
	}

	public void setMeasureRateEntity(MeasureRateEntity measureRateEntity) {
		this.measureRateEntity = measureRateEntity;
	}

	public Long getChoiceCodeCount() {
		return choiceCodeCount;
	}

	public void setChoiceCodeCount(Long choiceCodeCount) {
		this.choiceCodeCount = choiceCodeCount;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	

	 	
}
