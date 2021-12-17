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
    private Integer id;//instance field
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
    public Vote(Integer userId,Integer postId){
        this.userId=userId;
        this.postId=postId;
    }
    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof Vote))return false;
        Vote vote=(Vote) o;
        return Objects.equals(getId(),vote.getId())&&
                Objects.equals(getUserId(),vote.getUserId())&&
                Objects.equals(getPostId(),vote.getUserId());
    }
    @Override//hashcode() isn't used just yet
    public int hashcode(){
        return Objects.hash(getId(),getUserId(),getPostId());
    }
    @Override
    public String toString(){
        return "Vote{" +
                "id=" + id +
                ", userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}

