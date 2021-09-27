package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;

@Enity
@JsonIgnoreProperites({"hibernateLazyInitializer","handler"})
@Table(name="user")
public class User {
}
