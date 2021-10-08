package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Enity
@JsonIgnoreProperites({"hibernateLazyInitializer","handler"})
@Table(name="user")
public class User {
    private Integer id;
    private String username;
    @Column(unique=true)
    private String email;
    private String password;
    @Transient
    private Boolean loggedIn;
    @OneToMany(mappedBy="userId",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Post> posts;
    private List<vote> votes;
    private List<Comment> comments;
}
