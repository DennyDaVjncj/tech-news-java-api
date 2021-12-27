package com.technews.controller;
import com.technews.model.Post;
import com.technews.model.User;
import com.technews.repository.UserRepository;
import com.technews.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController//allows for json/xml response processing & object sending via API
public class UserController {
    @Autowired//injects dependencies as needed, optimizing efficiency/app weight. "new" operator instantiates regardless of need
    UserRepository repository;
    @Autowired
    VoteRepository voteRepository;

                  //'route'
    @GetMapping("/api/users")//first 'GET' request. metods without 'void' in signature must have return type
    public List<User> getAllUsers(){//prgrm will have mltpl users, hence List reference type [able to index trough]
        List<User> userList=repository.findAll();

        for (User u:userList){
            List<Post>postList=u.getPosts();
            for(Post p:postList){
                p.setVoteCount(voteRepository.countVotesByPostId(p.getId()));
            }
        }
        return userList;
    }
    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Integer id){
        User returnUser=repository.getOne(id);
        List<Post>postList=returnUser.getPosts();

        for (Post p:postList){
            p.setVoteCount(voteRepository.countVotesByPostId(p.getId()));
        }
        return returnUser;
    }
    @PostMapping("/api/users")//invocation of postMETHOD, adding new info to DB
    public User addUser(@RequestBody User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        repository.save(user);
        return user;
    }
    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User user){
        User tempUser=repository.getOne(id);

        if(!tempUser.equals(null)){
            user.setId(tempUser.getId());
            repository.save(user);
        }
        return user;
    }
    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }
}