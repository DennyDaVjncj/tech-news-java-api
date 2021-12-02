package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;//figure out what these imports are about & when they're invoked

@Entity
@JsonIgnoreProperties({"hibernateeLazyInitializer","handler"})
@Table(name="vote")
public class Vote implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer postId;
}
