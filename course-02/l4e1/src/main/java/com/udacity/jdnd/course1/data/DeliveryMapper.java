package com.udacity.jdnd.course1.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {
    @Select("SELECT * FROM DELIVERY WHERE id = #{id}")
    Delivery findDelivery(Integer id);

    @Insert("INSERT INTO DELIVERY (orderId, time) VALUES (#{orderID}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(Delivery delivery);

    @Delete("DELETE FROM DELIVERY WHERE id = #{id}")
    void deleteDelivery(Integer id);
}

