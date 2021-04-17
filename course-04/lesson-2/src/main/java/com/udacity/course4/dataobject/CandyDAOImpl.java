package com.udacity.course4.dataobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    // constants for retrieveAllCandies(): [
    private static final String SELECT_ALL_CANDIES =
            "SELECT * FROM candy";

    // a RowMapper returns an instance of CandyData class to represent the row
    // map query result columns to object attributes of CandyData
    private static final BeanPropertyRowMapper<CandyData> candyRowMapper = new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> retrieveAllCandies() {
        return jdbcTemplate.query(
          SELECT_ALL_CANDIES,
          candyRowMapper
        );
    }

    private static final String INSERT_INTO_DELIVERY =
            "INSERT INTO candy_delivery (candy_id, delivery_id)"
            + "VALUES (:candyId, :deliveryId)";

    @Override
    public void addCandyToDelivery(Long candyId, Long deliveryId) {

        KeyHolder key = new GeneratedKeyHolder();

        jdbcTemplate.update(
                INSERT_INTO_DELIVERY,
                new MapSqlParameterSource()
                        .addValue("candyId", candyId)
                        .addValue("deliveryId", deliveryId),
                key
        );
    }

    private static final String FIND_CANDY_BY_DELIVERY =
            "SELECT * FROM candy c"
            + "JOIN candy_delivery cd"
            + "ON c.id = cd.candy_id"
            + "WHERE cd.delivery_id = :deliveryId";

    @Override
    public List<CandyData> retrieveCandiesByDeliveryId(Long deliveryId) {
        return jdbcTemplate.query(
                FIND_CANDY_BY_DELIVERY,
                new MapSqlParameterSource().addValue("deliveryId", deliveryId),
                candyRowMapper
        );
    }
}
