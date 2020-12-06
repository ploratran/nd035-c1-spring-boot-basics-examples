package com.udacity.jwdnd.spring_security_basics.mapper;

import com.udacity.jwdnd.spring_security_basics.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // search user from User table by username:
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    // insert a user into User database and return the auto-generated userId:
    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);
}
