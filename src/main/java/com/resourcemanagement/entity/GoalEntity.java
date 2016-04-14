package com.resourcemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "goals")
public class GoalEntity {
	

    @Id
    @GeneratedValue
    @Column(name = "goal_id")
    private Long goalId;
    
    @Column(name = "goal_name", nullable = false)
    private String goalName;

    @Column(name = "status")
    private Integer status;
    
    
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    
    @Column(name = "type" )
    private Integer type;
    
    @Column(name = "update_at", nullable = false)
    private String updatedAt;
 
    @Column(name = "attachment", nullable = false)
	private boolean attachment;
	
	@Column(name = "discussion", nullable = false)
	private boolean discussion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="perspective_id",insertable=true, updatable=true,nullable=false,referencedColumnName="perspective_id")
    private PerspectiveEntity perspectiveEntity;
    
    public GoalEntity()
    {
    	
    }
	public GoalEntity(String goalName, Integer status, String createdAt, Integer type, String updatedAt,
			boolean attachment, boolean discussion, PerspectiveEntity perspectiveEntity) {
		super();
		this.goalName = goalName;
		this.status = status;
		this.createdAt = createdAt;
		this.type = type;
		this.updatedAt = updatedAt;
		this.attachment = attachment;
		this.discussion = discussion;
		this.perspectiveEntity = perspectiveEntity;
	}

	public Long getGoalId() {
		return goalId;
	}

	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isAttachment() {
		return attachment;
	}

	public void setAttachment(boolean attachment) {
		this.attachment = attachment;
	}

	public boolean isDiscussion() {
		return discussion;
	}

	public void setDiscussion(boolean discussion) {
		this.discussion = discussion;
	}


	public PerspectiveEntity getPerspectiveEntity() {
		return perspectiveEntity;
	}

	public void setPerspectiveEntity(PerspectiveEntity perspectiveEntity) {
		this.perspectiveEntity = perspectiveEntity;
	}

	
	

	



}
