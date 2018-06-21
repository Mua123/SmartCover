package com.cover.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cover.entity.User;
import com.cover.service.UserService;

@Controller
@RequestMapping("/user")

//这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
//这样保证了session中存在user这个对象
@SessionAttributes("user")
	public class UserController {
    
    @Autowired
    private UserService userServivce;
    
    //正常访问login页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    
    //表单提交过来的路径
    
    @RequestMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(User user,HttpServletRequest request){
    	 
        //调用service方法
    	System.out.println(user.getUsername()+"  "+user.getPassword());
        user = userServivce.checkLogin(user.getUsername(), user.getPassword());
        
        if(user != null){
        	
        	HttpSession session = request.getSession();
        	System.out.println(user+"0000000000");
            return "index";
            
            
        }
        
        return "login";
    }
    
    //测试超链接跳转到另一个页面是否可以取到session值
    @RequestMapping("/anotherpage")
    public String hrefpage(){
        
        return "anotherpage";
    }
    
    //注销方法
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session){
        //通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "login";
    }

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String Regist(User user,HttpServletRequest request){
        System.out.println(user.getUsername()+"  "+user.getPassword());
        userServivce.Regist(user);
       
        return "success";
    }
}