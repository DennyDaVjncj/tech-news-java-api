package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;

    @Transient
    private String userName;
    @Transient
    private int voteCount;
    private Integer userId;

    @NotNull
    @Temporal(TemporalType.Date)
    @Column(name="posted_at ")
    private Date postedAt=new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="updated_at ")
    private Date updatedAt=new Date();
    private List<Comment> comments;
}
