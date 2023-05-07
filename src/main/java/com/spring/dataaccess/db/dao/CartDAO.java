package com.spring.dataaccess.db.dao;

import com.spring.dataaccess.db.Cart;
import com.spring.dataaccess.db.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CartDAO {
    private final JdbcTemplate jdbcTemplate;
    private final CartMapper cartMapper;


    public long createCart() throws SQLException {
        String sql = "INSERT INTO cart VALUES ()";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM cart WHERE id = ?", id);
    }


    public Cart getById(Long id) {
        String SQLQuery = String.format("SELECT * FROM cart WHERE id = %o", id);
        return jdbcTemplate.query(SQLQuery, cartMapper).stream().findFirst().orElse(null);
    }
}
