package com.softengine.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntitiyModel implements Serializable {
    @CreatedDate
    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "updated_date")
    private Date updated_date;

}
