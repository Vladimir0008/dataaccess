package com.spring.dataaccess;

import com.spring.dataaccess.db.Product;
import com.spring.dataaccess.db.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class DataaccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataaccessApplication.class, args);

    }

}
