package com.resourcemanagement.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "discussions")
public class DiscussionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "discussion_id")
	private Long discussionId;

	@Column(name = "discussion_Title", nullable = false)
	private String discussionTitle;

	@Column(name = "type")
	private Integer type;

	@Column(name = "type_id")
	private Integer typeId;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "status")
	private Integer status;

	@Column(name = "created_at", nullable = false)
	private String createdAt;

	@Column(name = "updated_at", nullable = false)
	private String updatedAt;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id",insertable=false, updatable=false, 
    nullable=false)
    private CompanyEntity companyEntity;

    @OneToMany(cascade = CascadeType.ALL) 
    @JoinTable(name = "discussion_comments", joinColumns = { @JoinColumn(name = "discussion_id") }, inverseJoinColumns = { @JoinColumn(name = "comment_id") })
    private Set<CommentEntity> commentEntity;  
	
	
}
