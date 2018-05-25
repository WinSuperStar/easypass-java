package com.joshua.easypass.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.joshua.easypass.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>  {
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password and u.state = '激活'")
    public User find(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.username like %:username% AND u.phone like %:phone% AND u.roleid =:roleid AND u.state like %:state% ")
    public User[] getUsers(@Param("username") String username, @Param("phone") String phone, @Param("roleid") Integer roleid, @Param("state") String state);

    @Query("SELECT u FROM User u WHERE u.username like %:username% AND u.phone like %:phone% AND u.roleid =:roleid AND u.state like %:state%  AND   u.userid = :userid ")
    public User[] getUsersByOwner(@Param("username") String username, @Param("phone") String phone, @Param("roleid") Integer roleid, @Param("state") String state,@Param("userid") Integer userid);
    
    @Query("SELECT u FROM User u WHERE u.userid = :userid")
    public User getUser(@Param("userid") Integer userid);

    @Query("SELECT u FROM User u")
    public User[] getAllUsers();

    @Modifying
    @Query(value = "INSERT INTO User VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,(select rolename from role where roleid = ?14), ?14)", nativeQuery = true)
    void saveUser(@Param("userid") Integer userid,
                  @Param("username") String username,
                  @Param("password") String password,
                  @Param("gender") String gender,
                  @Param("state") String state,
                  @Param("phone") String phone,
                  @Param("certpath") String certpath,
                  @Param("certnum") Integer certnum,
                  @Param("createdate") Date createdate,
                  @Param("creator") String creator,
                  @Param("add1") String add1,
                  @Param("add1") String add2,
                  @Param("add1") String add3,
                  @Param("roleid") Integer roleid);

}