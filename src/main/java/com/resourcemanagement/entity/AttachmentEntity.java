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
import javax.persistence.Table;
@Entity
@Table(name = "attachments")
public class AttachmentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "attachment_id")
    private Long attachmentId;
    
	
	@Column(name="attachment_path", nullable = false)
	private String attachmentPath;
	
	@Column(name="attachment_name", nullable = false)
	private String attachmentName;
	
	@Column(name="type")
	private Integer type;
	
	@Column(name="type_id")
	private Long typeId;
	
	@Column(name="uploaded_at", nullable = false)
	private String uploadedAt;
	
	@Column(name="uploaded_by", nullable = false)
	private Long uploadedBy;
	
	@Column(name="size", nullable = false)
	private String size;
	
	
	@Column(name="status")
	private Integer status;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id",insertable=false, updatable=false, 
    nullable=false)
    private CompanyEntity companyEntity;

	
	 
}
