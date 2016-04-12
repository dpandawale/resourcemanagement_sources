package com.resourcemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_team_relations")
public class UserTeamEntity {

	@Id
    @GeneratedValue
    @Column(name = "user_team_id")
    private Long userTeamId;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 private UserEntity userEntity;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 private TeamMeasureEntity teamMeasureEntity;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 private TeamMilestoneEntity teamMilestoneEntity;
	 
	 public UserTeamEntity()
	 {
		 
	 }

	public Long getUserTeamId() {
		return userTeamId;
	}

	public void setUserTeamId(Long userTeamId) {
		this.userTeamId = userTeamId;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public TeamMeasureEntity getTeamMeasureEntity() {
		return teamMeasureEntity;
	}

	public void setTeamMeasureEntity(TeamMeasureEntity teamMeasureEntity) {
		this.teamMeasureEntity = teamMeasureEntity;
	}

	public TeamMilestoneEntity getTeamMilestoneEntity() {
		return teamMilestoneEntity;
	}

	public void setTeamMilestoneEntity(TeamMilestoneEntity teamMilestoneEntity) {
		this.teamMilestoneEntity = teamMilestoneEntity;
	}
	 
	 
 
}
