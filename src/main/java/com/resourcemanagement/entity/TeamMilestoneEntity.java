package com.resourcemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team_milestone_relations")
public class TeamMilestoneEntity {
		@Id
	    @GeneratedValue
	    @Column(name = "team_type_id")
	    private Long teamTypeId;
	 
	   @ManyToOne(cascade = CascadeType.ALL)
	   private MilestoneEntity milestoneEntity;
	   
	   @ManyToOne(cascade = CascadeType.ALL)
	   private TeamEntity teamEntity;
	   
	   @ManyToOne(cascade = CascadeType.ALL)
		private CompanyEntity companyEntity;

	   @Column(name = "type")
	   private Integer type;
	   
	   public TeamMilestoneEntity()
	   {
		   
	   }

	public Long getTeamTypeId() {
		return teamTypeId;
	}

	public void setTeamTypeId(Long teamTypeId) {
		this.teamTypeId = teamTypeId;
	}

	public MilestoneEntity getMilestoneEntity() {
		return milestoneEntity;
	}

	public void setMilestoneEntity(MilestoneEntity milestoneEntity) {
		this.milestoneEntity = milestoneEntity;
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
