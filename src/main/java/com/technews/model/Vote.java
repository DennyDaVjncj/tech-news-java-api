package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateeLazyInitializer","handler"})
@Table
public class Vote{
    private Integer id;
    private Integer userId;
    private Integer postId;
}
