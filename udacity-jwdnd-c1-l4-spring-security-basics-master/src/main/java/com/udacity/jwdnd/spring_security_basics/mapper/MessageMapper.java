package com.udacity.jwdnd.spring_security_basics.mapper;

import org.apache.ibatis.annotations.*;
import com.udacity.jwdnd.spring_security_basics.model.ChatMessage;

import java.util.List;

@Mapper
public interface MessageMapper {
    // search all messages in MESSAGES table
    // use List to store messages:
    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllMessages();

    // insert new messageText by username into MESSAGES table
    // primary key as messageId:
    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int addMessage(ChatMessage chatMessage);
}
