package com.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.domain.Users;

@Service(value = "userService")   
public class UserServiceImpl implements UserService{  
      
    private static String USER_COLLECTION = "users";  
  
    @Autowired  
    MongoOperations mongoTemplate;  
      
   
    public void saveUser(Users users){            
        mongoTemplate.save(users, USER_COLLECTION);            
    }        
    public Users findUserByName(String name){
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), Users.class, USER_COLLECTION);  
    }
	public void removeUser(String name) {
		mongoTemplate.remove(new Query(Criteria.where("name").is(name)),Users.class,USER_COLLECTION);
	}
	public void updateUser(String name,String key,String value) {
		mongoTemplate.updateFirst(new Query(Criteria.where("name").is(name)), Update.update(key, value), Users.class);
		
	}
	public List<Users> listUser() {
		return mongoTemplate.findAll(Users.class);
	}
}
