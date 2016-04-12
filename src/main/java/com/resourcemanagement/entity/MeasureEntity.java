package com.resourcemanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "measures")
public class MeasureEntity {
	
	 @Id
	    @GeneratedValue
	    @Column(name = "measure_id")
	    private Long measureId;
	    
	    @Column(name = "measure_name", nullable = false)
	    private String measureName;

	    
	    @Column(name = "status")
	    private Integer status;
	    
	    @Column(name = "type")
	    private Integer type;
	    
	    
	    @Column(name = "created_at", nullable = false)
	    private String createdAt;
	    
	    @Column(name = "updated_at", nullable = false)
	    private String updatedAt;
	    
	    @Column(name = "attachment", nullable = false)
		private boolean attachment;
		
		@Column(name = "discussion", nullable = false)
		private boolean discussion;
	 
	  /*  private Set<TeamMeasureEntity> teamMeasureEntity = new HashSet<TeamMeasureEntity>(0);
	    */
	  
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="goal_id",insertable=true, updatable=true, 
	    nullable=false)
	    private GoalEntity goalEntity;
	   
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="owner_user_id",insertable=true, updatable=true, 
	    nullable=false)
	    private UserEntity userEntity;
	    
	    /*@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="measure_cumulative_id",insertable=true, updatable=true, 
	    nullable=false)
	    private MeasureCumulativeEntity measureCumulativeEntity;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="informed_team_id",insertable=true, updatable=true, 
	    nullable=false)
	    private TeamEntity informedTeamEntity;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="involved_team_id",insertable=true, updatable=true, 
	    nullable=false)
	    private TeamEntity involvedTeamEntity;*/
	   
	 /*   @ManyToMany(cascade = {CascadeType.ALL})
	    @JoinTable(name="measure_projects", 
	                joinColumns={@JoinColumn(name="measure_id")}, 
	                inverseJoinColumns={@JoinColumn(name="project_id")})
	    private Set<ProjectEntity> projects = new HashSet<ProjectEntity>();*/

		public MeasureEntity(String measureName, Integer status, Integer type, String createdAt, String updatedAt,
				boolean attachment, boolean discussion, GoalEntity goalEntity, UserEntity userEntity) {
			super();
			this.measureName = measureName;
			this.status = status;
			this.type = type;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.attachment = attachment;
			this.discussion = discussion;
			this.goalEntity = goalEntity;
			this.userEntity = userEntity;
		}
	    
	    
	    
	    /*
	    @OneToOne(cascade = CascadeType.ALL)
	    private MeasureRateCountEntity measureRateEntity;*/
	    
	    

}
