package com.mypham.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
public abstract class BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "createdby" , columnDefinition = "text")
    @CreatedBy
    protected String createdBy;
    @Column(name = "createddate")
    @CreatedDate
    protected Date createdDate;
    @Column(name = "modifiedby" , columnDefinition = "text")
    @LastModifiedBy
    protected String modifiedBy;
    @Column(name = "modifieddate")
    @LastModifiedDate
    protected Date modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

}
