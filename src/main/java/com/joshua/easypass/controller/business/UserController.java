package com.joshua.easypass.controller.business;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joshua.easypass.constants.Contants;
import com.joshua.easypass.controller.BaseController;
import com.joshua.easypass.encap.CurrentUserSessionStorage;
import com.joshua.easypass.entity.Authlist;
import com.joshua.easypass.entity.User;
import com.joshua.easypass.service.AuthService;
import com.joshua.easypass.service.RoleService;
import com.joshua.easypass.service.UserService;
import com.joshua.easypass.util.AuthUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController extends BaseController {

    public final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthService authService;
    
    @PostMapping(value = "/login")
    public User Login(@RequestParam("username") String username, @RequestParam("password") String password) {
    	User u = userService.login(username, password);
    	if( u == null ) {
    		return  null;
    	}
		String authids = roleService.findAuthlist(u.getRoleid().intValue());
		List<Authlist> authlist = null;
		if (authids != null && StringUtils.isNotBlank(authids)) {
			authlist = authService.getAuthlist(authids);
		}
    	getRequest().getSession().setAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY, CurrentUserSessionStorage.fromUser(u,authlist));
    	u.setPassword(null);
        return u;
    }

    @PostMapping(value = "/addUser")
    public void addUser(@RequestParam("username") String username,
                        @RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        @RequestParam("roleid") Integer roleid,
                        @RequestParam("gender") String gender,
                        @RequestParam("state") String state,
                        @RequestParam("creator") String creator,
                        @RequestParam("certpath") String certpath) {
        Date currentTime = new Date();
        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRoleid(roleid);
        user.setGender(gender);
        user.setState(state);
        user.setCreatedate(currentTime);
        user.setCreator(creator);
        user.setCertpath(certpath);
        logger.info("新建用户："+user.toString());
        userService.addUser(user);
    }

    @PostMapping(value = "/users")
    public User[] getUsers(@RequestParam("username") String username,
                           @RequestParam("phone") String phone,
                           @RequestParam("roleid") Integer roleid,
                           @RequestParam("state") String state) {
    	
    	CurrentUserSessionStorage userSession=(CurrentUserSessionStorage)getRequest().getSession().getAttribute(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY);
    	boolean flag =AuthUtil.hasAuthByAuthData(userSession.getAuthList(), "QUERY_USERS_ALL");
        if(flag){
    	    return userService.getUsers(username, phone, roleid, ("所有".equals(state)?"":state));
        }else {
        	flag =AuthUtil.hasAuthByAuthData(userSession.getAuthList(), "QUERY_USERS_BY_OWNER");
        	if(flag){
        	   return userService.getUsersByOwner(username, phone, roleid, ("所有".equals(state)?"":state),userSession.getUserId().intValue());
        	}
        	   return  null;
        }
       
    }

    @PutMapping(value = "/user")
    public void updateUser(@RequestParam("userid") String userid,
                             @RequestParam("username") String username,
                             @RequestParam("phone") String phone,
                             @RequestParam("password") String password,
                             @RequestParam("roleid") Integer roleid,
                             @RequestParam("gender") String gender,
                             @RequestParam("state") String state,
                             @RequestParam("createdate") String createdate,
                             @RequestParam("creator") String creator,
                             @RequestParam("certpath") String certpath) {
        Date currentTime = new Date();
        User user = new User();
        user.setUserid(Integer.parseInt(userid));
        user.setUsername(username);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRoleid(roleid);
        user.setGender(gender);
        user.setState(state);
        user.setCreatedate(currentTime);
        user.setCreator(creator);
        user.setCertpath(certpath);
        logger.info("更新用户："+user.toString());
        userService.addUser(user);
    }

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/allUsers")
    public User[] getAllUsers() {
        return userService.getAllUsers();
    }

//    @PostMapping(value="/user")
//    public void addUser(@Valid User user, BindingResult bingdingResult){
//
//    }
}
