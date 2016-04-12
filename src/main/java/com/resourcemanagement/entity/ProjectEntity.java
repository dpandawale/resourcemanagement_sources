package com.resourcemanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class ProjectEntity {
	// project name, description, owner, informed team, involved team
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@Column(name = "created_at", nullable = false)
	private String createdAt;

	@Column(name = "updated_at", nullable = false)
	private String updatedAt;

	@Column(name = "status")
	private Long status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "created_by", insertable = true, updatable = true, nullable = false)
	private UserEntity userEntity;

	@Column(name = "is_default", nullable = false)
	private boolean isDefault;

	@Column(name = "m_id")
	private Long mId;

	@Column(name = "type")
	private Long type;
	
	@ManyToMany(mappedBy = "projects")
	private Set<MeasureEntity> measures = new HashSet<MeasureEntity>();

	/*
	 * private Set<MeasureEntity> measures = new HashSet<MeasureEntity>();
	 * 
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable( name = "project_measures", joinColumns = @JoinColumn(name =
	 * "project_id"), inverseJoinColumns = @JoinColumn(name = "measure_id") )
	 * public Set<MeasureEntity> getMeasures() { return measures; }
	 */

}
