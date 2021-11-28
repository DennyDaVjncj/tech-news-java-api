package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="comment")
public class Comment {
    private Integer id;
    private String commentText;
    private Integer userId;
    private Integer postId;//all these iVariables being class level
}
