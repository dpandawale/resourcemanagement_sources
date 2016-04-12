package com.resourcemanagement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perspectives")
public class PerspectiveEntity {

	@Id
	@GeneratedValue
	@Column(name = "perspective_id")
	private long perspectiveId;

	@Column(name = "persp_name", nullable = false)
	private String persp_name;
	
	@Column(name = "created_at", nullable = false)
	private String created_at;
	
	@Column(name = "updated_at", nullable = false)
	private String updated_at;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "type")
    private Integer type;
	
	@Column(name = "attachment", nullable = false)
	private boolean attachment;
	
	@Column(name = "discussion", nullable = false)
	private boolean discussion;
	
	
	@Column(name = "pers_order")
	private int order;
	
	
	 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id",insertable=true, updatable=true,nullable=false)
    private CompanyEntity companyEntity;

    public PerspectiveEntity()
    {
    	
    }

    
	public PerspectiveEntity( String persp_name, String created_at, String updated_at, int status,
			Integer type, boolean attachment, boolean discussion, int order, CompanyEntity companyEntity) {
		super();
		this.persp_name = persp_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.status = status;
		this.type = type;
		this.attachment = attachment;
		this.discussion = discussion;
		this.order = order;
		this.companyEntity = companyEntity;
	}


	public long getPerspectiveId() {
		return perspectiveId;
	}

	public void setPerspectiveId(long perspectiveId) {
		this.perspectiveId = perspectiveId;
	}

	public String getPersp_name() {
		return persp_name;
	}

	public void setPersp_name(String persp_name) {
		this.persp_name = persp_name;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}
	
    
	
	
	
}
