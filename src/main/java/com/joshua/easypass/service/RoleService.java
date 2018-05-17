package com.joshua.easypass.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.easypass.entity.Role;
import com.joshua.easypass.repository.RoleRepository;

@Service
public class RoleService {
    public final static Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleRepository roleRepo;

    public Role[] getRoles() {
        return roleRepo.getRoles();
    }

    public Role getRole(Integer id) {
        return roleRepo.getRole(id);
    }

    @Transactional
    public void addRole(Role role) {
        roleRepo.save(role);
    }

    public String findAuthlist(Integer roleid) {
    	logger.info("roleid:"+roleid);
    	Role role = roleRepo.getRole(roleid);
    	logger.info("authList:"+role.getAuthlist());
        return role.getAuthlist();
    }
    @Transactional
    public void updateRole(String rolename, String authlist, Integer roleid) {
        roleRepo.updateRole(rolename, authlist, roleid);
    }
}
