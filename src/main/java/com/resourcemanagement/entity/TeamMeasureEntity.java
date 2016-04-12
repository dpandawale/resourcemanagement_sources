package com.resourcemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team_measure_relations")
public class TeamMeasureEntity {
		@Id
	    @GeneratedValue
	    @Column(name = "team_type_id")
	    private Long teamTypeId;
	 
	   @ManyToOne(cascade = CascadeType.ALL)
	   private MeasureEntity measureEntity;
	   
	   @ManyToOne(cascade = CascadeType.ALL)
	   private TeamEntity teamEntity;
	   
	   @Column(name = "type")
	   private Integer type;
	   
	   @ManyToOne(cascade = CascadeType.ALL)
		private CompanyEntity companyEntity;

	public Long getTeamTypeId() {
		return teamTypeId;
	}

	public void setTeamTypeId(Long teamTypeId) {
		this.teamTypeId = teamTypeId;
	}

	public MeasureEntity getMeasureEntity() {
		return measureEntity;
	}

	public void setMeasureEntity(MeasureEntity measureEntity) {
		this.measureEntity = measureEntity;
	}

	public TeamEntity getTeamEntity() {
		return teamEntity;
	}

	public void setTeamEntity(TeamEntity teamEntity) {
		this.teamEntity = teamEntity;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}

	   
	   
	   
}
