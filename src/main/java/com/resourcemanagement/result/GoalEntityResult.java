package com.resourcemanagement.result;

public class GoalEntityResult{
	private Long goalId;
	private String goalName;
	
	private Long perspectiveId;
	private String perspectiveName;
	public Long getGoalId() {
		return goalId;
	}
	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}
	public Long getPerspectiveId() {
		return perspectiveId;
	}
	public void setPerspectiveId(Long perspectiveId) {
		this.perspectiveId = perspectiveId;
	}
	public String getPerspectiveName() {
		return perspectiveName;
	}
	public void setPerspectiveName(String perspectiveName) {
		this.perspectiveName = perspectiveName;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	
}