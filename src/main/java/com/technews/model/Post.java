package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
//import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//props to be ignored when serializing to json
@Table(name="post")
public class Post implements Serializable{
    @Id//id private iField to serve as foreign key/unique identifier
    @GeneratedValue(strategy=GenerationType.AUTO)//clause says that an id int gets gened auto
    private Integer id;
    private String title;
    private String postUrl;

    @Transient//indicates data that we don't want persisted on our database
    private String userName;
    @Transient
    private int voteCount;
    private Integer userId;

    @NotNull//signals to jpa that this column isn't allowed to be null
    @Temporal(TemporalType.Date)//this annotation allows us to us the date type in our database
    @Column(name="postedAt")//designates column name
    private Date postedAt=new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="updatedAt")
    private Date updatedAt=new Date();

    @OneToMany(mappedBy="postId",cascade=CascadeType.All,fetch=FetchType.LAZY)
    private List<Comment> comments;

    public Post(){
    }
    public Post(Integer id,String title,String postUrl,int voteCount,Integer userId){
        this.id=id;
        this.title=title;
        this.postUrl=postUrl;
        this.voteCount=voteCount;
        this.userId=userId;
    }//constructor method
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getPostUrl(){
        return postUrl;
    }
    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public int getVoteCount(){
        return voteCount;
    }
    public void setVoteCount(int voteCount){
        this.voteCount = voteCount;
    }
    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    public Date getPostedAt(){
        return postedAt;
    }
    public void setPostedAt(Date postedAt){
        this.postedAt = postedAt;
    }
    public Date getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
    }
    public List<Comment> getComments(){
        return comments;
    }
    public void setComments(List<Comment> comments){
        this.comments = comments;
    }

    @Override//existing method functionality is being overridden?
    public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof Post))return false;//line not fully understood
        Post post=(Post)o;//new instance with reference type being compared to og object?
        return getVoteCount()==post.getVoteCount()&&
                Objects.equals(getId(),post.getId())&&
                Objects.equals(getTitle(),post.getTitle())&&
                Objects.equals(getPostUrl(),post.getPostUrl())&&
                Objects.equals(getUserName(),post.getUserName())&&
                Objects.equals(getUserId(),post.getUserId())&&
                Objects.equals(getPostedAt(),post.getPostedAt())&&
                Objects.equals(getUpdatedAt(),post.getUpdatedAt())&&
                Objects.equals(getComments(),post.getComments());
    }
    @Override
    public int hashcode(){
        return Objects.hash(getId(),getTitle(),getPostUrl(),getUserName(),getVoteCount(),
                getUserId(),getPostedAt(),getUpdatedAt(),getComments());
    }
    @Override
    public String toString(){
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}
