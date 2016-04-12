package com.resourcemanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="teams")
public class TeamEntity {
	 	@Id
	    @GeneratedValue
	    @Column(name = "team_id")
	    private Long teamId;
	 	
	    @Column(name = "team_name", nullable = false)
	    private String teamName;

	    @Column(name = "type")
	    private Integer type;
	   
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="created_by",insertable=true, updatable=true, 
	    nullable=false)
	    private UserEntity userEntity;
		
		@Column(name="created_at", nullable = false)
		private String createdAt;
		
		@Column(name="updated_at", nullable = false)
		private String updatedAt;
		
	   
	    
	    
}
