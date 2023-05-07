package com.spring.dataaccess.db;

import com.spring.dataaccess.db.dao.CartDAO;
import com.spring.dataaccess.db.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartMapper implements RowMapper<Cart> {
    // private final JdbcTemplate jdbcTemplate;
    private  final ProductDAO productDAO;


    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getLong("id"));

        long cartId = cart.getId();
        List<Product> products = productDAO.getByCartId(cartId);
        cart.setProducts(products);

        return cart;
    }

    /*private List<Product> getProductsForCart(long cartId) {
        String sql = "SELECT p.* FROM product p JOIN cart c ON c.id = p.cart_id WHERE c.id = ?";
        return jdbcTemplate.query(sql, new Object[]{cartId}, (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getBigDecimal("price"));
            return product;
        });
    }*/
}

