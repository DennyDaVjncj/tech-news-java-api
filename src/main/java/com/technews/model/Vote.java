package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;//figure out what these imports are about & when they're invoked

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="vote")
public class Vote implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer postId;
    //instance fields above

    public Vote(){}//what is this method for?
    //constructor method below
    public Vote(Integer id,Integer userId,Integer postId){
        this.id=id;
        this.userId=userId;
        this.postId=postId;
    }
}

