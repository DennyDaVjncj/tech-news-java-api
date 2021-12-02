package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateeLazyInitializer","handler"})
@Table(name="vote")
public class Vote{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer postId;
}
