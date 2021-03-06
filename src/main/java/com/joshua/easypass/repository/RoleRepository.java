package com.joshua.easypass.repository;

import com.joshua.easypass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.joshua.easypass.entity.Role;

import java.util.Date;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r.authlist FROM Role r WHERE r.roleid = :roleid")
    public String findAuthlist(@Param("roleid") Integer roleid);

    @Query("SELECT r FROM Role r")
    public Role[] getRoles();

    @Query("SELECT r FROM Role r WHERE r.roleid=:roleid")
    public Role getRole(@Param("roleid") Integer roleid);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Role r set r.rolename =:rolename, r.authlist=:authlist WHERE r.roleid =:roleid")
    void updateRole(@Param("rolename") String rolename, @Param("authlist") String authlist, @Param("roleid") Integer roleid);

}
