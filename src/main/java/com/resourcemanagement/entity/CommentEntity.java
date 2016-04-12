package com.resourcemanagement.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_id")
	private Long commentId;
	
	@Column(name = "comment_text", nullable = false)
	private String commentText;

	@Column(name = "status")
	private int status;

	@Column(name = "created_at", nullable = false)
	private String createdAt;
	
	@Column(name = "created_date", nullable = false)
	private String createdDate;
	

	@Column(name = "updated_at", nullable = false)
	private String updatedAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = false)
	private UserEntity userEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", insertable = false, updatable = false, nullable = false)
	private CompanyEntity companyEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "discussion_id", insertable = false, updatable = false, nullable = false)
	private DiscussionEntity discussionEntity;
	

}
