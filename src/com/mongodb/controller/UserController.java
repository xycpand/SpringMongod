package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mongodb.domain.Users;
import com.mongodb.service.UserService;
/**
 * 用户操作
 * 创建时间	2015年3月10日
 *
 */
@Controller
@RequestMapping("/users") 
public class UserController {
	
	
	@Autowired  
    private  UserService userService;  
      
    @RequestMapping("/index")  
    public ModelAndView index(){  
        ModelAndView mav = new ModelAndView("/index");  
        return mav;  
    }  
    @RequestMapping("/addpage")  
    public String addUser(Users user){
        //ModelAndView mav = new ModelAndView("/add");            
        return "add";  
    } 
    @RequestMapping(value ="/save")  
    public ModelAndView saveUser(Users users){
        ModelAndView mav = new ModelAndView("/result");            
        System.out.println("save:"+users); 
        mav.addObject("message","添加成功");
        userService.saveUser(users);
        return mav;  
    }  
    
    @RequestMapping("/findpage")  
    public ModelAndView findPage(Users user){
        ModelAndView mav = new ModelAndView("/get");
        return mav;  
    }  
      
    @RequestMapping("/find")  
    public ModelAndView findUser(Users users){
        users = userService.findUserByName(users.getName());
        System.out.println("find:"+users); 
        ModelAndView mav = new ModelAndView("/user");
        mav.addObject("user", users);
        return mav;  
    }  
    @RequestMapping("/findAll")  
    public ModelAndView findAllUser(Users users){
        List<Users> allUser = userService.listUser();
        ModelAndView mav = new ModelAndView("/findAll");
        mav.addObject("allUser", allUser);
        return mav;  
    }  
    @RequestMapping("/deletepage")  
    public ModelAndView deletePage(Users user){
        ModelAndView mav = new ModelAndView("/delete");
        return mav;  
    } 
    @RequestMapping("/delete")  
    public ModelAndView delete(Users user){
        ModelAndView mav = new ModelAndView("/index");
        userService.removeUser(user.getName());
        return mav;  
    } 
    
    @RequestMapping("/modfigPage")  
    public ModelAndView modfigPage(Users user){
        ModelAndView mav = new ModelAndView("/modfig");
        return mav;  
    } 
    
    @RequestMapping("/modfig")  
    public ModelAndView modfig(Users user,String key,String value){
        ModelAndView mav = new ModelAndView("/index");
        userService.updateUser(user.getName(),key,value);
        return mav;  
    }
    
//    public static void main(String[] args) {
//    
//    	ApplicationContext ac = new ClassPathXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
//    	UserService userService = (UserService) ac.getBean("UserService");
//    	Users user=new Users();
//    	user.setAge(1000);
//    	user.setName("zhang");
//    	userService.saveUser(user);
//	}

}
