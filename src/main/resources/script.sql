
CREATE TABLE cart (
id BIGINT AUTO_INCREMENT PRIMARY KEY
);
CREATE TABLE product (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
product_name VARCHAR(50),
price DECIMAL(9,2),
cart_id BIGINT,
FOREIGN KEY (cart_id) REFERENCES cart(id)
);