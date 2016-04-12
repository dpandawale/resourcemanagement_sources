package com.resourcemanagement.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
    
    @Formula(value = " concat(first_name, ' ', last_name) ")
    private String fullName;
    
    @Column(name = "password", nullable = false)
    private String password;

    /*@Column(name = "email_id",  unique = true,nullable = false)
    */
    @Column(name = "email_id",nullable = false)
    private String emailId;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "user_type", nullable = false)
    private Integer userType;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "type")
    private Integer type;
    
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private String updatedAt;
 
    @Column(name = "phone", nullable = false)
    private String phone;
   
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id",insertable=true, updatable=true, 
            nullable=false)
    private CompanyEntity companyEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "report_users", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "report_id") })
    private Set<ReportToUserEntity> reportUsers;
	public Set<ReportToUserEntity> ReportToUsers() {
		return this.reportUsers;
	}
	
    public UserEntity()
    {
    	
    }

	public UserEntity(String password, String emailId, String firstName, String lastName, Integer userType,
			Integer status, Integer type, String createdAt, String updatedAt, String phone,
			CompanyEntity companyEntity) {
		super();
		this.password = password;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.status = status;
		this.type = type;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.phone = phone;
		this.companyEntity = companyEntity;
	}



    
   
}
