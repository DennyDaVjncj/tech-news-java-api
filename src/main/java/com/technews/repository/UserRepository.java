package com.technews.repository;

//classes were essentially blueprints, where interfaces are more like 'contracts'
//whatever class implements an interface, it must abide by all terms of contract, it must host all methods within interface
//a Data Access Object (DAO) in Java is any class that retrieves, stores and searches data

import com.technews.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
