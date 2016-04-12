package com.resourcemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "measure_cumulative")
public class MeasureCumulativeEntity {
	
    @Id
    @GeneratedValue
    @Column(name = "measure_cumulative_id")
    private Long measureCumulativeId;
    
    @Column(name = "measure_cumulative_value")
    private Integer measureCumulativeValue;
    
    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private String createdAt;
    
    @OneToOne  
    @PrimaryKeyJoinColumn
    private MeasureEntity measureEntity;
    

	public Long getMeasureCumulativeId() {
		return measureCumulativeId;
	}

	public void setMeasureCumulativeId(Long measureCumulativeId) {
		this.measureCumulativeId = measureCumulativeId;
	}

	public Integer getMeasureCumulativeValue() {
		return measureCumulativeValue;
	}

	public void setMeasureCumulativeValue(Integer measureCumulativeValue) {
		this.measureCumulativeValue = measureCumulativeValue;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public MeasureEntity getMeasureEntity() {
		return measureEntity;
	}

	public void setMeasureEntity(MeasureEntity measureEntity) {
		this.measureEntity = measureEntity;
	}


	
}
