package com.joshua.easypass.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.joshua.easypass.entity.User;
import com.joshua.easypass.repository.RoleRepository;
import com.joshua.easypass.repository.UserRepository;

@Service
public class UserService {
    public final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private RoleRepository roleRepo;   
    

    public User[] getUsers(String username, String phone, Integer roleid, String state) {
        logger.info("查询中：用户名为{},手机号码为{}, 岗位为{}, 状态为{}", username, phone, roleid, state);
        
        List<User> resultList = null;
        Specification<User> querySpecifi = new Specification<User>() {
        	
			private static final long serialVersionUID = 1L;

			@Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(username)){
                    predicates.add(criteriaBuilder.like(root.get("username"), "%"+username+"%"));
                }
                if(StringUtils.isNotBlank(phone)){
                    predicates.add(criteriaBuilder.like(root.get("phone"), "%"+phone+"%"));
                }
                if(null != roleid){
                    predicates.add(criteriaBuilder.equal(root.get("roleid"), roleid));
                }
                if(StringUtils.isNotBlank(state)){
                    predicates.add(criteriaBuilder.like(root.get("state"), "%"+state+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList =  this.userRepo.findAll(querySpecifi);
        if(resultList!=null && !resultList.isEmpty()) {
        	return resultList.toArray(new User[] {});
        }
        return null;
    }
    
    public User[] getUsersByOwner(String username, String phone, Integer roleid, String state,Integer userid) {
        logger.info("查询中：用户名为{},手机号码为{}, 岗位为{}, 状态为{}", username, phone, roleid, state);
        
        List<User> resultList = null;
        Specification<User> querySpecifi = new Specification<User>() {
        	
			private static final long serialVersionUID = 1L;

			@Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(username)){
                    predicates.add(criteriaBuilder.like(root.get("username"), "%"+username+"%"));
                }
                if(StringUtils.isNotBlank(phone)){
                    predicates.add(criteriaBuilder.like(root.get("phone"), "%"+phone+"%"));
                }
                if(null != roleid){
                    predicates.add(criteriaBuilder.equal(root.get("roleid"), roleid));
                }
                if(StringUtils.isNotBlank(state)){
                    predicates.add(criteriaBuilder.like(root.get("state"), "%"+state+"%"));
                }
                if(null != userid){
                    predicates.add(criteriaBuilder.equal(root.get("userid"), userid));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList =  this.userRepo.findAll(querySpecifi);
        if(resultList!=null && !resultList.isEmpty()) {
        	return resultList.toArray(new User[] {});
        }
        return null;
    }

    public User[] getAllUsers(){return userRepo.getAllUsers();}

    public User getUser(Integer userid) {
        return userRepo.getUser(userid);
    }

    public User login(String username, String password) {
        logger.info("登录中，用户名为{}， 密码为{}", username, password);
        return userRepo.find(username, password);
    }
    
    @Transactional
    public void addUser(User user) {
        userRepo.saveUser(user.getUserid(),user.getUsername(),user.getPassword(),user.getGender(),user.getState(),user.getPhone(),user.getCertpath(),
                user.getCertnum(),user.getCreatedate(),user.getCreator(),user.getAdd1(),user.getAdd2(),user.getAdd3(), user.getRoleid());
    }
    

    
    public Page<User> queryUserPage(User user,int currentPageIndex, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC,"userid");
		Pageable pageable = PageRequest.of(currentPageIndex,pageSize,sort);
    	return userRepo.findAll(pageable);
	}    

    @Transactional
	public void updateUser(User user) {
		Optional<User> userDb = userRepo.findById(user.getUserid());
		User u = userDb.get();
		u.setAdd1(user.getAdd1());
		u.setAdd2(user.getAdd2());
		u.setAdd3(user.getAdd3());
		u.setCertnum(user.getCertnum());
		u.setCertpath(user.getCertpath());
		u.setGender(user.getGender());
		u.setPhone(user.getPhone());
		u.setPassword(user.getPassword());
		u.setRoleid(user.getRoleid());
		u.setRolename(roleRepo.getRole(user.getRoleid()).getRolename());
		u.setState(user.getState());
		userRepo.save(u);
	}
}
