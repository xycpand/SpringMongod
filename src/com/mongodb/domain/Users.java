package com.mongodb.domain;
/**
 * 用户
 * 创建时间	2015年3月10日
 *
 */
public class Users{  
    String uid;  
    String name;  
    int age;  
      
      
    public String getUid() {  
        return uid;  
    }  
    public void setUid(String uid) {  
        this.uid = uid;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    @Override  
    public String toString() {  
      return "{USERS:{id:"+this.uid+", name:"+this.name+",age:"+this.age+"}}";
    	
    }  
      
}
