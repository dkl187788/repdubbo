package com.ailk.dubbo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ailk.dubbo.model.User;
import com.ailk.dubbo.service.IUserService;

@Controller("userAction")
@RequestMapping(value="/login")
public class UserController{

    private static Log  logger =  LogFactory.getLog(UserController.class);
   
    private String message;

    private String username;

    private String password;

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("login")
    public String login(@RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password){
    	 logger.info("----------------------------------------------------------------");
    	 System.out.println("============================================");
        try{
            Map<String, String> param = new HashMap<String, String>();
            param.put("username", username);
            param.put("password", password);
            User user = userService.getUserByMapSql(param);
            System.out.println("------------------------"+user);
            if(user != null){
                message = "登录成功！";
                logger.info(message);
            }else{
                message = "登录失败！";
                logger.info(message);
            }
        }catch(Exception e){
            logger.warn(e.getMessage());
            e.printStackTrace();
        }
        request.setAttribute("message", message);
        return "index";  // 转到webapp/index.jsp页面
    }

    /******** set/get ********/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}